package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Supplier;
import com.sadman.medicalinventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierApiController {
    @Autowired
    SupplierService service;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers(Model model) {
        return service.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)
            throws RecordNotFoundException {
        Supplier supplier = service.getSupplierById(supplierId);
        return ResponseEntity.ok().body(supplier);
    }

    @PostMapping("/suppliers")
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
        return service.createSupplier(supplier);
    }

    @PutMapping("/suppliers/edit/{id}")
    public Supplier editSupplierById(@RequestBody Supplier newSupplier, @PathVariable(value = "id") Long supplierId) {
        return service.updateSupplier(newSupplier, supplierId);
    }

    @DeleteMapping("/suppliers/delete/{id}")
    public void deleteSupplierById(@PathVariable(value = "id") Long supplierId){
        service.deleteSupplierById(supplierId);
    }
}

