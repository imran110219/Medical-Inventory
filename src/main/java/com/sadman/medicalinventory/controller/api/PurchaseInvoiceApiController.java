package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.PurchaseInvoiceService;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseInvoiceApiController {
    @Autowired
    PurchaseInvoiceService service;

    @GetMapping("/purchaseinvoices")
    public List<PurchaseInvoice> getAllPurchaseInvoices(Model model) {
        return service.getAllPurchaseInvoices();
    }

    @GetMapping("/purchaseinvoices/{id}")
    public ResponseEntity<PurchaseInvoice> getPurchaseInvoiceById(@PathVariable(value = "id") String purchaseInvoiceId)
            throws RecordNotFoundException {
        PurchaseInvoice purchaseInvoice = service.getPurchaseInvoiceById(purchaseInvoiceId);
        return ResponseEntity.ok().body(purchaseInvoice);
    }

    @PostMapping("/purchaseinvoices")
    public PurchaseInvoice createPurchaseInvoice(@Valid @RequestBody PurchaseInvoice purchaseInvoice) {
        return service.createPurchaseInvoice(purchaseInvoice);
    }

    @PutMapping("/purchaseinvoices/edit/{id}")
    public PurchaseInvoice editPurchaseInvoicesById(@RequestBody PurchaseInvoice newPurchaseInvoice, @PathVariable(value = "id") String purchaseInvoiceId) {
        return service.updatePurchaseInvoice(newPurchaseInvoice, purchaseInvoiceId);
    }

    @DeleteMapping("/purchaseinvoices/delete/{id}")
    public void deletePurchaseInvoiceById(@PathVariable(value = "id") String purchaseInvoiceId){
        service.deletePurchaseInvoiceById(purchaseInvoiceId);
    }
}
