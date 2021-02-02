package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    BrandService service;

    @GetMapping("/brands")
    public List<Brand> getAllBrands(Model model) {
        return service.getAllBrands();
    }

    @GetMapping("/brands/company/{id}")
    public List<Brand> getBrandsByCompanyId(@PathVariable(value = "id") Long companyId){
        return service.getBrandsByCompanyId(companyId);
    }

    @GetMapping("/brands/generic/{id}")
    public List<Brand> getBrandsByGenericId(@PathVariable(value = "id") Long genericId){
        return service.getBrandsByGenericId(genericId);
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable(value = "id") Long brandId)
            throws RecordNotFoundException {
        Brand brand = service.getBrandById(brandId);
        return ResponseEntity.ok().body(brand);
    }

    @PostMapping(value = "/brands", consumes = MediaType.ALL_VALUE)
    public Brand createBrand(@Valid @RequestBody Brand brand) {
        return service.createBrand(brand);
    }

    @PutMapping("/brands/edit/{id}")
    public Brand editBrandById(@RequestBody Brand newBrand, @PathVariable(value = "id") Long brandId) {
        return service.updateBrand(newBrand, brandId);
    }

    @DeleteMapping("/brands/delete/{id}")
    public void deleteBrandsById(@PathVariable(value = "id") Long brandId){
        service.deleteBrandById(brandId);
    }
}