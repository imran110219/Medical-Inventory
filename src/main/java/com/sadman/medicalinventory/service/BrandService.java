package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.BrandDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.repository.BrandRepository;
import com.sadman.medicalinventory.repository.DosageFormRepository;
import com.sadman.medicalinventory.repository.GenericRepository;
import com.sadman.medicalinventory.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository repository;

    @Autowired
    DosageFormRepository dosageFormRepository;

    @Autowired
    GenericRepository genericRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public List<Brand> getAllBrands()
    {
        return repository.findAll();
    }

    public List<Brand> getBrandsByManufacturerId(Long manufacturerId)
    {
        return repository.getBrandsByManufacturerId(manufacturerId);
    }

    public List<Brand> getBrandsByGenericId(Long manufacturerId)
    {
        return repository.getBrandsByGenericId(manufacturerId);
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
                    brand.setDosageForm(newBrand.getDosageForm());
                    brand.setManufacturer(newBrand.getManufacturer());
                    brand.setGeneric(newBrand.getGeneric());
                    brand.setPurchasePrice(newBrand.getPurchasePrice());
                    brand.setSalePrice(newBrand.getSalePrice());
                    return repository.save(brand);
                })
                .orElseGet(() -> {
                    newBrand.setId(id);
                    return repository.save(newBrand);
                });
    }

    public ResponseEntity<Object> deleteBrandById(Long id){
        repository.deleteById(id);
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
        } else return ResponseEntity.ok().body("Brand is Deleted Successfully");
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    public long countAllBrand(){
        return repository.count();
    }

    public void updateBrandDTO(BrandDTO newBrandDTO, Long brandId) {
        Brand newBrand = new Brand();
        newBrand.setName(newBrandDTO.getName());
        newBrand.setStrength(newBrandDTO.getStrength());
        DosageForm dosageForm = dosageFormRepository.getOne(newBrandDTO.getDosageFormId());
        newBrand.setDosageForm(dosageForm);
        Generic generic = genericRepository.getOne(newBrandDTO.getGenericId());
        newBrand.setGeneric(generic);
        Manufacturer manufacturer = manufacturerRepository.getOne(newBrandDTO.getManufacturerId());
        newBrand.setManufacturer(manufacturer);
        newBrand.setPurchasePrice(newBrandDTO.getPurchasePrice());
        newBrand.setSalePrice(newBrandDTO.getSalePrice());
        updateBrand(newBrand,brandId);
    }
}
