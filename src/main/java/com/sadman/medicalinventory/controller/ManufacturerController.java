package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Manufacturer;
import com.sadman.medicalinventory.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerService service;


    @RequestMapping(value = "/manufacturers")
    public String getAllUsers(Model model) {
        List<Manufacturer> list = service.getAllManufacturers();
        model.addAttribute("manufacturers", list);
        return "manufacturer-list";
    }

}
