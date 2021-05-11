package com.sadman.medicalinventory;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private PurchaseService purchaseService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId("PI1618989514455");

    }
}