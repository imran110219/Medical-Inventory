package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository repository;

    public List<Brand> getAllBrands()
    {
        return repository.findAll();
    }

    public List<Brand> getBrandsByCompanyId(Long companyId)
    {
        return repository.getBrandsByCompanyId(companyId);
    }

    public List<Brand> getBrandsByGenericId(Long companyId)
    {
        return repository.getBrandsByGenericId(companyId);
    }

    public Brand getBrandById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Brand createBrand(Brand brand){
        return repository.save(brand);
    }

    public Brand updateBrand(Brand newBrand, Long id)
    {
        return repository.findById(id)
                .map(brand -> {
                    brand.setName(newBrand.getName());
                    brand.setStrength(newBrand.getStrength());
                    brand.setManufacturer(newBrand.getManufacturer());
                    brand.setGeneric(newBrand.getGeneric());
                    brand.setPrice(newBrand.getPrice());
                    return repository.save(brand);
                })
                .orElseGet(() -> {
                    newBrand.setId(id);
                    return repository.save(newBrand);
                });
    }

    public void deleteBrandById(Long id){
        repository.deleteById(id);
    }
}
