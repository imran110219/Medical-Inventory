package com.sadman.medicalinventory;

import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Test {
    @Autowired
    BrandRepository repository;

    public Brand getBrandById(Long id)
    {
        Optional<Brand> brand = repository.findById(id);

        return brand.get();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getBrandById(1L));
    }
}
