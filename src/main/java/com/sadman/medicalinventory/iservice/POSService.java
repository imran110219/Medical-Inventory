package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.model.SaleInvoice;

/**
 * @author Sadman
 */
public interface POSService {
    SaleInvoice makePayment(InvoiceDTO invoiceDTO);
}
