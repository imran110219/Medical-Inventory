package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SupplierService;
import com.sadman.medicalinventory.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    SupplierService service;
    
    @RequestMapping(value = "/suppliers")
    public String getAllUsers(Model model) {
        List<Supplier> list = service.getAllSuppliers();
        model.addAttribute("suppliers", list);
        model.addAttribute("supplier", new Supplier());
        return "supplier-list";
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)
            throws RecordNotFoundException {
        Supplier supplier = service.getSupplierById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping(value="/suppliers/add")
    public ResponseEntity<String> addSupplier(Supplier supplier){
        service.createSupplier(supplier);
        return new ResponseEntity<>("Supplier is added successfully", HttpStatus.OK);
    }

    @PutMapping("/suppliers/edit/{id}")
    public ResponseEntity<String> editSupplierById(@RequestBody Supplier newSupplier, @PathVariable(value = "id") Long supplierId) {
        service.updateSupplier(newSupplier, supplierId);
        return new ResponseEntity<>("Supplier is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteSupplierById(@PathVariable(value = "id") Long supplierId){
        return service.deleteSupplierById(supplierId);
    }

    @PostMapping(value="/suppliers/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
