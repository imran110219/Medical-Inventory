package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Company;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository repository;

    public List<Company> getAllCompanies()
    {
        return repository.findAll();
    }

    public Company getCompanyById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Company createCompany(Company company){
        return repository.save(company);
    }

    public Company updateCompany(Company newCompany, Long id)
    {
        return repository.findById(id)
                .map(company -> {
                    company.setName(newCompany.getName());
                    company.setAddress(newCompany.getAddress());
                    return repository.save(company);
                })
                .orElseGet(() -> {
                    newCompany.setId(id);
                    return repository.save(newCompany);
                });
    }

    public void deleteCompanyById(Long id){
        repository.deleteById(id);
    }
}
