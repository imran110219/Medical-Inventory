package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SaleInvoiceService;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.repository.SaleInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleInvoiceServiceImpl implements SaleInvoiceService {

    @Autowired
    SaleInvoiceRepository repository;

    public List<SaleInvoice> getAllSaleInvoices() {
        return repository.findAll();
    }

    public SaleInvoice getSaleInvoiceById(String id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public SaleInvoice createSaleInvoice(SaleInvoice saleInvoice){
        return repository.save(saleInvoice);
    }

    public SaleInvoice updateSaleInvoice(SaleInvoice newSaleInvoice, String id) {
        return repository.findById(id)
                .map(invoice -> {
                    invoice.setUser(newSaleInvoice.getUser());
                    invoice.setTotal(newSaleInvoice.getTotal());
                    invoice.setVat(newSaleInvoice.getVat());
                    invoice.setDiscount(newSaleInvoice.getDiscount());
                    invoice.setPayable(newSaleInvoice.getPayable());
                    invoice.setPaid(newSaleInvoice.getPaid());
                    invoice.setReturned(newSaleInvoice.getReturned());
                    return repository.save(invoice);
                })
                .orElseGet(() -> {
                    newSaleInvoice.setId(id);
                    return repository.save(newSaleInvoice);
                });
    }

    public void deleteSaleInvoiceById(String id){
        repository.deleteById(id);
    }
}
