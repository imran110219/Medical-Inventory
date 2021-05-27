package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.ReturnListDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Return;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import com.sadman.medicalinventory.repository.ReturnRepository;
import com.sadman.medicalinventory.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnService {
    @Autowired
    ReturnRepository repository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    SaleRepository saleRepository;

    public List<Return> getAllReturns() {
        return repository.findAll();
    }

    public Return getReturnById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Return createReturn(Return returnObject){
        return repository.save(returnObject);
    }

    public Return updateReturn(Return newReturn, Long id) {
        return repository.findById(id)
                .map(returnObject -> {
                    returnObject.setSale(newReturn.getSale());
                    returnObject.setPurchase(newReturn.getPurchase());
                    returnObject.setTotal(newReturn.getTotal());
                    returnObject.setWastage(newReturn.getWastage());
                    return repository.save(returnObject);
                })
                .orElseGet(() -> {
                    newReturn.setId(id);
                    return repository.save(newReturn);
                });
    }

    public void deleteReturnById(Long id){
        repository.deleteById(id);
    }

    public void returnProcess(ReturnListDTO returnListDTO) {
        List<Return> returnList = new ArrayList<>();
        for (int i = 0; i < returnListDTO.getReturnDTOList().size(); i++) {
            Return ret = new Return();
//            Purchase purchase = purchaseRepository.getOne(returnListDTO.getReturnDTOList().get(i).getPurchaseId());
//            Sale sale = saleRepository.getOne(returnListDTO.getReturnDTOList().get(i).getSaleId());
//            ret.setPurchase(purchase);
//            ret.setSale(sale);
            ret.setQuantity(returnListDTO.getReturnDTOList().get(i).getQuantity());
            ret.setUnitPrice(returnListDTO.getReturnDTOList().get(i).getUnitPrice());
            ret.setDeduction(returnListDTO.getReturnDTOList().get(i).getDeduction());
            ret.setTotal(returnListDTO.getReturnDTOList().get(i).getReturnPrice());
            returnList.add(ret);
        }
        repository.saveAll(returnList);
    }
}
