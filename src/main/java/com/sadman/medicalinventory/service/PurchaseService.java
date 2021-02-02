package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repository;

    public List<Purchase> getAllPurchases()
    {
        return repository.findAll();
    }

    public Purchase getPurchaseById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Purchase createPurchase(Purchase purchase){
        return repository.save(purchase);
    }

    public Purchase updatePurchase(Purchase newPurchase, Long id)
    {
        return repository.findById(id)
                .map(purchase -> {
                    purchase.setBrand(newPurchase.getBrand());
                    purchase.setPrice(newPurchase.getPrice());
                    purchase.setQuantity(newPurchase.getQuantity());
                    purchase.setTotal(newPurchase.getTotal());
                    purchase.setSupplier(newPurchase.getSupplier());
                    return repository.save(purchase);
                })
                .orElseGet(() -> {
                    newPurchase.setId(id);
                    return repository.save(newPurchase);
                });
    }

    public void deletePurchaseById(Long id){
        repository.deleteById(id);
    }
}
