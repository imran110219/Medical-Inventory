package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Manufacturer;
import com.sadman.medicalinventory.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ManufacturerController {
    @Autowired
    ManufacturerService service;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getAllCompanies(Model model) {
        return service.getAllCompanies();
    }

    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> getCompanyById(@PathVariable(value = "id") Long companyId)
            throws RecordNotFoundException {
        Manufacturer manufacturer = service.getCompanyById(companyId);
        return ResponseEntity.ok().body(manufacturer);
    }

    @PostMapping("/manufacturers")
    public Manufacturer createCompany(@Valid @RequestBody Manufacturer manufacturer) {
        return service.createCompany(manufacturer);
    }

    @PutMapping("/manufacturers/edit/{id}")
    public Manufacturer editCompanyById(@RequestBody Manufacturer newManufacturer, @PathVariable(value = "id") Long companyId) {
        return service.updateCompany(newManufacturer, companyId);
    }

    @DeleteMapping("/manufacturers/delete/{id}")
    public void deleteCompanyById(@PathVariable(value = "id") Long companyId){
        service.deleteCompanyById(companyId);
    }
}
