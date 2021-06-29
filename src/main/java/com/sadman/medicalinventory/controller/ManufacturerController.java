package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.ManufacturerService;
import com.sadman.medicalinventory.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerService service;

    @RequestMapping(value = "/manufacturers")
    public String getAllUsers(Model model) {
        List<Manufacturer> list = service.getAllManufacturers();
        model.addAttribute("manufacturer", new Manufacturer());
        model.addAttribute("manufacturers", list);
        return "manufacturer-list";
    }

    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable(value = "id") Long manufacturerId)
            throws RecordNotFoundException {
        Manufacturer manufacturer = service.getManufacturerById(manufacturerId);
        return ResponseEntity.ok(manufacturer);
    }

    @PostMapping(value="/manufacturers/add")
    public ResponseEntity<String> addManufacturer(Manufacturer manufacturer){
        service.createManufacturer(manufacturer);
        return new ResponseEntity<>("Manufacturer is added successfully", HttpStatus.OK);
    }

    @PutMapping("/manufacturers/edit/{id}")
    public ResponseEntity<String> editManufacturerById(@RequestBody Manufacturer newManufacturer, @PathVariable(value = "id") Long manufacturerId) {
        service.updateManufacturer(newManufacturer, manufacturerId);
        return new ResponseEntity<>("Manufacturer is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/manufacturers/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteManufacturerById(@PathVariable(value = "id") Long manufacturerId){
        return service.deleteManufacturerById(manufacturerId);
    }

    @PostMapping(value="/manufacturers/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
