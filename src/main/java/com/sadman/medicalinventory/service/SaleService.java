package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository repository;

    public List<Sale> getAllSales() {
        return repository.findAll();
    }

    public Sale getSaleById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Sale createSale(Sale sale){
        return repository.save(sale);
    }

    public Sale updateSale(Sale newSale, Long id) {
        return repository.findById(id)
                .map(sale -> {
                    sale.setStock(newSale.getStock());
                    sale.setInvoice(newSale.getInvoice());
                    sale.setPrice(newSale.getPrice());
                    sale.setQuantity(newSale.getQuantity());
                    sale.setTotal(newSale.getTotal());
                    return repository.save(sale);
                })
                .orElseGet(() -> {
                    newSale.setId(id);
                    return repository.save(newSale);
                });
    }

    public void deleteSaleById(Long id){
        repository.deleteById(id);
    }
}
