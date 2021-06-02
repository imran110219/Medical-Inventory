package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.IndicationService;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndicationController {
    @Autowired
    private IndicationService service;

    @RequestMapping(value = "/indications")
    public String getAllIndications(Model model) {
        List<Indication> list = service.getAllIndications();
        model.addAttribute("indication", new Indication());
        model.addAttribute("indications", list);
        return "indication-list";
    }

    @PostMapping(value="/indications/add")
    public ResponseEntity<String> addGeneric(Indication indication){
        service.createIndication(indication);
        return new ResponseEntity<>("Indication is added successfully", HttpStatus.OK);
    }

    @PostMapping(value="/indications/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
