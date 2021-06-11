package com.sadman.medicalinventory;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.repository.BrandRepository;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import com.sadman.medicalinventory.repository.StockRepository;
import com.sadman.medicalinventory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

//    @Autowired
//    private PurchaseService purchaseService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BrandRepository brandRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(brandRepository.count());
    }
}