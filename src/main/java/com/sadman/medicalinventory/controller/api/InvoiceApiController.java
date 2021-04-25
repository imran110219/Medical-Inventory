package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceApiController {
    @Autowired
    InvoiceService service;

    @GetMapping("/invoices")
    public List<SaleInvoice> getAllInvoices(Model model) {
        return service.getAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<SaleInvoice> getInvoiceById(@PathVariable(value = "id") String invoiceId)
            throws RecordNotFoundException {
        SaleInvoice invoice = service.getInvoiceById(invoiceId);
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping("/invoices")
    public SaleInvoice createInvoice(@Valid @RequestBody SaleInvoice invoice) {
        return service.createInvoice(invoice);
    }

    @PutMapping("/invoices/edit/{id}")
    public SaleInvoice editInvoicesById(@RequestBody SaleInvoice newInvoice, @PathVariable(value = "id") String invoiceId) {
        return service.updateInvoice(newInvoice, invoiceId);
    }

    @DeleteMapping("/invoices/delete/{id}")
    public void deleteInvoiceById(@PathVariable(value = "id") String invoiceId){
        service.deleteInvoiceById(invoiceId);
    }
}
