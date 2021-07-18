package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.GenericController;
import com.sadman.medicalinventory.controller.IndicationController;
import com.sadman.medicalinventory.iservice.StockService;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private GenericController genericController;

    @Autowired
    private IndicationController indicationController;

    @Autowired
    private StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        List<Stock> stocks = stockService.getOutOfStock();
//        for (Stock stock: stocks) {
//            System.out.println(stock.getPurchase().getBrand().getName());
//        }
        System.out.println("run");
    }
}