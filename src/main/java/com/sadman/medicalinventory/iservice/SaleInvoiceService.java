package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.SaleInvoice;

import java.util.List;

/**
 * @author Sadman
 */
public interface SaleInvoiceService {
    List<SaleInvoice> getAllSaleInvoices();

    SaleInvoice getSaleInvoiceById(String id) throws RecordNotFoundException;

    SaleInvoice createSaleInvoice(SaleInvoice saleInvoice);

    SaleInvoice updateSaleInvoice(SaleInvoice newSaleInvoice, String id);

    void deleteSaleInvoiceById(String id);
}
