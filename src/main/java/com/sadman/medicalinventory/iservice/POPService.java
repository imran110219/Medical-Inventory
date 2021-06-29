package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.PurchaseInvoiceDTO;
import com.sadman.medicalinventory.model.PurchaseInvoice;

/**
 * @author Sadman
 */
public interface POPService {
    PurchaseInvoice makePayment(PurchaseInvoiceDTO purchaseInvoiceDTO);
}
