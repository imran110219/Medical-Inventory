package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.service.BrandService;
import com.sadman.medicalinventory.service.DosageFormService;
import com.sadman.medicalinventory.service.GenericService;
import com.sadman.medicalinventory.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService service;

    @Autowired
    private DosageFormService dosageFormService;

    @Autowired
    private GenericService genericService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/brands")
    public String getAllUsers(Model model) {
        List<Brand> brandList = service.getAllBrands();
        List<DosageForm> dosageFormList = dosageFormService.getAllDosageForms();
        List<Generic> genericList = genericService.getAllGenerics();
        List<Manufacturer> manufacturerList = manufacturerService.getAllManufacturers();
        model.addAttribute("brand", new Brand());
        model.addAttribute("dosageforms", dosageFormList);
        model.addAttribute("generics", genericList);
        model.addAttribute("manufacturers", manufacturerList);
        model.addAttribute("brands", brandList);
        return "brand-list";
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable(value = "id") Long brandId)
            throws RecordNotFoundException {
        Brand brand = service.getBrandById(brandId);
        return ResponseEntity.ok(brand);
    }

    @PostMapping(value="/brands/add")
    public ResponseEntity<String> addBrand(Brand brand){
        service.createBrand(brand);
        return new ResponseEntity<>("Brand is added successfully", HttpStatus.OK);
    }

    @PutMapping("/brands/edit/{id}")
    public ResponseEntity<String> editBrandById(@RequestBody Brand newBrand, @PathVariable(value = "id") Long brandId) {
        service.updateBrand(newBrand, brandId);
        return new ResponseEntity<>("Brand is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/brands/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBrandById(@PathVariable(value = "id") Long brandId){
        service.deleteBrandById(brandId);
        return new ResponseEntity<>("Brand is Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping(value="/brands/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
