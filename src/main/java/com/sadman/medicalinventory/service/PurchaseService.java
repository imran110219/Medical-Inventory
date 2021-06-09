package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import com.sadman.medicalinventory.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repository;

    @Autowired
    StockRepository stockRepository;

    public List<Purchase> getAllPurchases() {
        return repository.findAll();
    }

    public List<Purchase> getPurchasesByNotInStock() {
        List<Long> purchaseIds = stockRepository.findPurchaseIdsInStock();
        return repository.findAllByIdNotContains(purchaseIds);
    }

    public List<Purchase> getPurchasesByBrandId(Long brandId) {
        return repository.getPurchasesByBrandId(brandId);
    }

    public List<Purchase> getPurchasesByPurchaseInvoiceId(String purchaseInvoiceId) {
        return repository.findAllByPurchaseInvoiceId(purchaseInvoiceId);
    }

    public Purchase getPurchaseById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Purchase createPurchase(Purchase purchase){
        return repository.save(purchase);
    }

    public Purchase updatePurchase(Purchase newPurchase, Long id) {
        return repository.findById(id)
                .map(purchase -> {
                    purchase.setBrand(newPurchase.getBrand());
                    purchase.setPurchaseInvoice(newPurchase.getPurchaseInvoice());
                    purchase.setBatchNo(newPurchase.getBatchNo());
                    purchase.setBox(newPurchase.getBox());
                    purchase.setQuantity(newPurchase.getQuantity());
                    purchase.setUnitPrice(newPurchase.getUnitPrice());
                    purchase.setDiscount(newPurchase.getDiscount());
                    purchase.setTotal(newPurchase.getTotal());
                    purchase.setExpiryDate(newPurchase.getExpiryDate());
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
