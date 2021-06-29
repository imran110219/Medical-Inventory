package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.PurchaseService;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Indication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseApiController {
    @Autowired
    PurchaseService service;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchases(Model model) {
        return service.getAllPurchases();
    }

    @GetMapping("/purchases/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable(value = "id") Long purchaseId)
            throws RecordNotFoundException {
        Purchase purchase = service.getPurchaseById(purchaseId);
        return ResponseEntity.ok().body(purchase);
    }

    @PostMapping("/purchases")
    public Purchase createPurchase(@Valid @RequestBody Purchase purchase) {
        return service.createPurchase(purchase);
    }

    @PutMapping("/purchases/edit/{id}")
    public Purchase editPurchaseById(@RequestBody Purchase newPurchase, @PathVariable(value = "id") Long purchaseId) {
        return service.updatePurchase(newPurchase, purchaseId);
    }

    @DeleteMapping("/purchases/delete/{id}")
    public void deletePurchaseById(@PathVariable(value = "id") Long purchaseId){
        service.deletePurchaseById(purchaseId);
    }
}
