package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.ManufacturerService;
import com.sadman.medicalinventory.model.Manufacturer;
import com.sadman.medicalinventory.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
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

    public ResponseEntity<Object> deleteManufacturerById(Long id){
        repository.deleteById(id);
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
        } else return ResponseEntity.ok().body("Successfully deleted specified record");
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
