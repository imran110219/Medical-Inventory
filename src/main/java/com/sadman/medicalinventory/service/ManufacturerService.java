package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Manufacturer;
import com.sadman.medicalinventory.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    ManufacturerRepository repository;

    public List<Manufacturer> getAllManufacturers() {
        return repository.findAll();
    }

    public Manufacturer getManufacturerById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Manufacturer createManufacturer(Manufacturer manufacturer){
        return repository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer newManufacturer, Long id) {
        return repository.findById(id)
                .map(company -> {
                    company.setName(newManufacturer.getName());
                    company.setAddress(newManufacturer.getAddress());
                    return repository.save(company);
                })
                .orElseGet(() -> {
                    newManufacturer.setId(id);
                    return repository.save(newManufacturer);
                });
    }

    public void deleteManufacturerById(Long id){
        repository.deleteById(id);
    }
}
