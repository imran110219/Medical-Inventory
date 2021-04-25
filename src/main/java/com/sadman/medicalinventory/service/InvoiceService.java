package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;

    public List<SaleInvoice> getAllInvoices() {
        return repository.findAll();
    }

    public SaleInvoice getInvoiceById(String id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public SaleInvoice createInvoice(SaleInvoice invoice){
        return repository.save(invoice);
    }

    public SaleInvoice updateInvoice(SaleInvoice newInvoice, String id)
    {
        return repository.findById(id)
                .map(invoice -> {
                    invoice.setUser(newInvoice.getUser());
                    invoice.setTotal(newInvoice.getTotal());
                    invoice.setVat(newInvoice.getVat());
                    invoice.setDiscount(newInvoice.getDiscount());
                    invoice.setPayable(newInvoice.getPayable());
                    invoice.setPaid(newInvoice.getPaid());
                    invoice.setReturned(newInvoice.getReturned());
                    return repository.save(invoice);
                })
                .orElseGet(() -> {
                    newInvoice.setId(id);
                    return repository.save(newInvoice);
                });
    }

    public void deleteInvoiceById(String id){
        repository.deleteById(id);
    }
}
