package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import com.sadman.medicalinventory.repository.PurchaseInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseInvoiceService {

    @Autowired
    PurchaseInvoiceRepository repository;

    public List<PurchaseInvoice> getAllPurchaseInvoices() {
        return repository.findAll();
    }

    public PurchaseInvoice getPurchaseInvoiceById(String id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public PurchaseInvoice createPurchaseInvoice(PurchaseInvoice purchaseInvoice){
        return repository.save(purchaseInvoice);
    }

    public PurchaseInvoice updatePurchaseInvoice(PurchaseInvoice newPurchaseInvoice, String id)
    {
        return repository.findById(id)
                .map(purchaseInvoice -> {
                    purchaseInvoice.setSupplier(newPurchaseInvoice.getSupplier());
                    purchaseInvoice.setTotal(newPurchaseInvoice.getTotal());
                    purchaseInvoice.setVat(newPurchaseInvoice.getVat());
                    purchaseInvoice.setDiscount(newPurchaseInvoice.getDiscount());
                    purchaseInvoice.setPayable(newPurchaseInvoice.getPayable());
                    purchaseInvoice.setPaid(newPurchaseInvoice.getPaid());
                    purchaseInvoice.setReturned(newPurchaseInvoice.getReturned());
                    return repository.save(purchaseInvoice);
                })
                .orElseGet(() -> {
                    newPurchaseInvoice.setId(id);
                    return repository.save(newPurchaseInvoice);
                });
    }

    public void deletePurchaseInvoiceById(String id){
        repository.deleteById(id);
    }
}
