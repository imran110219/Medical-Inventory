package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    public List<Brand> getBrandsByManufacturerId(Long companyId);
    public List<Brand> getBrandsByGenericId(Long genericId);
}
