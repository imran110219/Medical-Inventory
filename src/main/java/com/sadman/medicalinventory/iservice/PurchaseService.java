package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Purchase;

import java.util.List;

/**
 * @author Sadman
 */
public interface PurchaseService {
    List<Purchase> getAllPurchases();

    List<Purchase> getPurchasesByNotInStock();

    List<Purchase> getPurchasesByBrandId(Long brandId);

    List<Purchase> getPurchasesByPurchaseInvoiceId(String purchaseInvoiceId);

    Purchase getPurchaseById(Long id) throws RecordNotFoundException;

    Purchase createPurchase(Purchase purchase);

    Purchase updatePurchase(Purchase newPurchase, Long id);

    void deletePurchaseById(Long id);

    double getTotalPurchaseAmount();
}
