package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.PurchaseInvoice;

import java.util.List;

/**
 * @author Sadman
 */
public interface PurchaseInvoiceService {
    List<PurchaseInvoice> getAllPurchaseInvoices();

    PurchaseInvoice getPurchaseInvoiceById(String id) throws RecordNotFoundException;

    PurchaseInvoice createPurchaseInvoice(PurchaseInvoice purchaseInvoice);

    PurchaseInvoice updatePurchaseInvoice(PurchaseInvoice newPurchaseInvoice, String id);

    void deletePurchaseInvoiceById(String id);
}
