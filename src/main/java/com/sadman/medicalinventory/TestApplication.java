//package com.sadman.medicalinventory;
//
//import com.sadman.medicalinventory.model.Generic;
//import com.sadman.medicalinventory.model.Indication;
//import com.sadman.medicalinventory.service.BrandService;
//import com.sadman.medicalinventory.service.CompanyService;
//import com.sadman.medicalinventory.service.GenericService;
//import com.sadman.medicalinventory.service.IndicationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.List;
//import java.util.Set;
//
//@SpringBootApplication
//public class TestApplication implements CommandLineRunner {
//    @Autowired
//    private BrandService brandService;
//    @Autowired
//    private CompanyService companyService;
//    @Autowired
//    private GenericService genericService;
//    @Autowired
//    private IndicationService indicationService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestApplication.class, args);
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        Generic generic = genericService.getGenericById(1L);
//        Indication indication = indicationService.getIndicationById(1L);
//        List<Generic> genericList = indicationService.getGenericsByIndicationId(1L);
//        Set<Indication> indicationList = generic.getIndications();
//        for (Generic g: genericList) {
//            System.out.println(g.getName());
//        }
//        for (Indication i: indicationList) {
//            System.out.println(i.getName());
//        }
//    }
//}