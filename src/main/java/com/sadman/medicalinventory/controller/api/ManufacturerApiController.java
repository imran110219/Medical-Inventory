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
public class ManufacturerApiController {
    @Autowired
    ManufacturerService service;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getAllManufacturers(Model model) {
        return service.getAllManufacturers();
    }

    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable(value = "id") Long companyId)
            throws RecordNotFoundException {
        Manufacturer manufacturer = service.getManufacturerById(companyId);
        return ResponseEntity.ok().body(manufacturer);
    }

    @PostMapping("/manufacturers")
    public Manufacturer createManufacturer(@Valid @RequestBody Manufacturer manufacturer) {
        return service.createManufacturer(manufacturer);
    }

    @PutMapping("/manufacturers/edit/{id}")
    public Manufacturer editManufacturerById(@RequestBody Manufacturer newManufacturer, @PathVariable(value = "id") Long companyId) {
        return service.updateManufacturer(newManufacturer, companyId);
    }

    @DeleteMapping("/manufacturers/delete/{id}")
    public void deleteManufacturerById(@PathVariable(value = "id") Long companyId){
        service.deleteManufacturerById(companyId);
    }
}
