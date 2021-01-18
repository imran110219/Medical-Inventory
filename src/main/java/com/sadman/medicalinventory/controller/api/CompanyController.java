package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Company;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.service.CompanyService;
import com.sadman.medicalinventory.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyService service;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(Model model)
    {
        return service.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long companyId)
            throws RecordNotFoundException {
        Company company = service.getCompanyById(companyId);
        return ResponseEntity.ok().body(company);
    }

    @PostMapping("/companies")
    public Company createCompany(@Valid @RequestBody Company company) {
        return service.createCompany(company);
    }

    @PutMapping("/companies/edit/{id}")
    public Company editCompanyById(@RequestBody Company newCompany, @PathVariable(value = "id") Long companyId) {
        return service.updateCompany(newCompany, companyId);
    }

    @DeleteMapping("/companies/delete/{id}")
    public void deleteCompanyById(@PathVariable(value = "id") Long companyId){
        service.deleteCompanyById(companyId);
    }
}
