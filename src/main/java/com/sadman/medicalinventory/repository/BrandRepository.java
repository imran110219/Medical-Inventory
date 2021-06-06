package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> getBrandsByManufacturerId(Long companyId);
    List<Brand> getBrandsByGenericId(Long genericId);
    boolean existsByName(String name);
}
