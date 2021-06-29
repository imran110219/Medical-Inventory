package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Manufacturer;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sadman
 */
public interface ManufacturerService {
    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(Long id) throws RecordNotFoundException;

    Manufacturer createManufacturer(Manufacturer manufacturer);

    Manufacturer updateManufacturer(Manufacturer newManufacturer, Long id);

    ResponseEntity<Object> deleteManufacturerById(Long id);

    boolean existsByName(String name);
}
