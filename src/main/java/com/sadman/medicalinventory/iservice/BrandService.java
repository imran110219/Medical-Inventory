package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.BrandDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sadman
 */
public interface BrandService {
    List<Brand> getAllBrands();

    List<Brand> getBrandsByManufacturerId(Long manufacturerId);

    List<Brand> getBrandsByGenericId(Long manufacturerId);

    Brand getBrandById(Long id) throws RecordNotFoundException;

    Brand createBrand(Brand brand);

    Brand updateBrand(Brand newBrand, Long id);

    ResponseEntity<Object> deleteBrandById(Long id);

    boolean existsByName(String name);

    long countAllBrand();

    void updateBrandDTO(BrandDTO newBrandDTO, Long brandId);
}
