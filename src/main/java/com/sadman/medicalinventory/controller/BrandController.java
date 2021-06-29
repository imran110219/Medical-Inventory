package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.BrandDTO;
import com.sadman.medicalinventory.dto.IndicationDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.BrandService;
import com.sadman.medicalinventory.iservice.DosageFormService;
import com.sadman.medicalinventory.iservice.GenericService;
import com.sadman.medicalinventory.iservice.ManufacturerService;
import com.sadman.medicalinventory.model.*;
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
    BrandService service;

    @Autowired
    DosageFormService dosageFormService;

    @Autowired
    GenericService genericService;

    @Autowired
    ManufacturerService manufacturerService;

    @RequestMapping(value = "/brands")
    public String getAllUsers(Model model) {
        List<Brand> brandList = service.getAllBrands();
        List<DosageForm> dosageFormList = dosageFormService.getAllDosageForms();
        List<Generic> genericList = genericService.getAllGenerics();
        List<Manufacturer> manufacturerList = manufacturerService.getAllManufacturers();
        model.addAttribute("brand", new Brand());
        model.addAttribute("branddto", new BrandDTO());
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

//    @PutMapping("/brands/edit/{id}")
//    public ResponseEntity<String> editBrandById(@RequestBody Brand newBrand, @PathVariable(value = "id") Long brandId) {
//        service.updateBrand(newBrand, brandId);
//        return new ResponseEntity<>("Brand is Edited Successfully", HttpStatus.OK);
//    }

    @PutMapping("/brands/edit/{id}")
    public ResponseEntity<String> editBrandById(@RequestBody BrandDTO newBrandDTO, @PathVariable(value = "id") Long brandId) {
//        service.updateBrand(newBrand, brandId);
        System.out.println(newBrandDTO);
        service.updateBrandDTO(newBrandDTO, brandId);
        return new ResponseEntity<>("Brand is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/brands/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteBrandById(@PathVariable(value = "id") Long brandId){
        return service.deleteBrandById(brandId);
    }

    @PostMapping(value="/brands/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
