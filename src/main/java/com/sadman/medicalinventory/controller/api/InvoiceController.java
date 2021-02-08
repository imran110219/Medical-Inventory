package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Invoice;
import com.sadman.medicalinventory.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    InvoiceService service;

    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices(Model model) {
        return service.getAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") String invoiceId)
            throws RecordNotFoundException {
        Invoice invoice = service.getInvoiceById(invoiceId);
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
        return service.createInvoice(invoice);
    }

    @PutMapping("/invoices/edit/{id}")
    public Invoice editInvoicesById(@RequestBody Invoice newInvoice, @PathVariable(value = "id") String invoiceId) {
        return service.updateInvoice(newInvoice, invoiceId);
    }

    @DeleteMapping("/invoices/delete/{id}")
    public void deleteInvoiceById(@PathVariable(value = "id") String invoiceId){
        service.deleteInvoiceById(invoiceId);
    }
}
