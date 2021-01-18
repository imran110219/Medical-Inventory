//package com.sadman.medicalinventory;
//
//import com.sadman.medicalinventory.model.Brand;
//import com.sadman.medicalinventory.model.Company;
//import com.sadman.medicalinventory.model.Generic;
//import com.sadman.medicalinventory.repository.BrandRepository;
//import com.sadman.medicalinventory.repository.CompanyRepository;
//import com.sadman.medicalinventory.repository.GenericRepository;
//import com.sadman.medicalinventory.service.BrandService;
//import com.sadman.medicalinventory.service.CompanyService;
//import com.sadman.medicalinventory.service.GenericService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootApplication
//public class TestApplication implements CommandLineRunner {
//    @Autowired
//    private BrandService brandService;
//    @Autowired
//    private CompanyService companyService;
//    @Autowired
//    private GenericService genericService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestApplication.class, args);
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        // save idCard along with persons
//        Brand brand = new Brand();
//        Generic generic = genericService.getGenericById(1L);
//        Company company = companyService.getCompanyById(1L);
////        brand.setId(6L);
//        brand.setName("Napa Test");
//        brand.setStrength("2 ML");
//        brand.setGeneric(generic);
//        brand.setCompany(company);
//        brandService.createBrand(brand);
//        System.out.println("Done!");
//    }
//}