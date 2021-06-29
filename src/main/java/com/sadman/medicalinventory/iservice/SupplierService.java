package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Supplier;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sadman
 */
public interface SupplierService {
    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id) throws RecordNotFoundException;

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Supplier newSupplier, Long id);

    ResponseEntity<Object> deleteSupplierById(Long id);

    boolean existsByName(String name);
}
