package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Return;
import com.sadman.medicalinventory.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnService {
    @Autowired
    ReturnRepository repository;

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
                    returnObject.setInvoice(newReturn.getInvoice());
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
}
