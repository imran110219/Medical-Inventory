package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.GenericController;
import com.sadman.medicalinventory.controller.IndicationController;
import com.sadman.medicalinventory.model.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private GenericController genericController;

    @Autowired
    private IndicationController indicationController;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ResponseEntity<Generic> generic = genericController.getGenericById(1L);
        indicationController.getIndicationById(1L);
        System.out.println(generic.getBody().getName());
    }
}