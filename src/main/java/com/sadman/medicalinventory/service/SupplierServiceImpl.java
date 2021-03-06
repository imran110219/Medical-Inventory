package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SupplierService;
import com.sadman.medicalinventory.model.Supplier;
import com.sadman.medicalinventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository repository;

    public List<Supplier> getAllSuppliers()
    {
        return repository.findAll();
    }

    public Supplier getSupplierById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Supplier createSupplier(Supplier supplier){
        return repository.save(supplier);
    }

    public Supplier updateSupplier(Supplier newSupplier, Long id) {
        return repository.findById(id)
                .map(supplier -> {
                    supplier.setName(newSupplier.getName());
                    supplier.setPhone(newSupplier.getPhone());
                    supplier.setAddress(newSupplier.getAddress());
                    return repository.save(supplier);
                })
                .orElseGet(() -> {
                    newSupplier.setId(id);
                    return repository.save(newSupplier);
                });
    }

    public ResponseEntity<Object> deleteSupplierById(Long id){
        repository.deleteById(id);
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
        } else return ResponseEntity.ok().body("Supplier is Deleted Successfully");
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
