package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SaleInvoiceService;
import com.sadman.medicalinventory.model.SaleInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleInvoiceApiController {
    @Autowired
    SaleInvoiceService service;

    @GetMapping("/saleinvoices")
    public List<SaleInvoice> getAllSaleInvoices(Model model) {
        return service.getAllSaleInvoices();
    }

    @GetMapping("/saleinvoices/{id}")
    public ResponseEntity<SaleInvoice> getSaleInvoiceById(@PathVariable(value = "id") String saleInvoiceId)
            throws RecordNotFoundException {
        SaleInvoice saleInvoice = service.getSaleInvoiceById(saleInvoiceId);
        return ResponseEntity.ok().body(saleInvoice);
    }

    @PostMapping("/saleinvoices")
    public SaleInvoice createSaleInvoice(@Valid @RequestBody SaleInvoice saleInvoice) {
        return service.createSaleInvoice(saleInvoice);
    }

    @PutMapping("/saleinvoices/edit/{id}")
    public SaleInvoice editSaleInvoicesById(@RequestBody SaleInvoice newSaleInvoice, @PathVariable(value = "id") String saleInvoiceId) {
        return service.updateSaleInvoice(newSaleInvoice, saleInvoiceId);
    }

    @DeleteMapping("/saleinvoices/delete/{id}")
    public void deleteSaleInvoiceById(@PathVariable(value = "id") String saleInvoiceId){
        service.deleteSaleInvoiceById(saleInvoiceId);
    }
}
