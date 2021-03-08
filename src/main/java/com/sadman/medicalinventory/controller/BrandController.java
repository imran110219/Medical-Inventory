package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService service;


    @RequestMapping(value = "/brands")
    public String getAllUsers(Model model) {
        List<Brand> list = service.getAllBrands();
        model.addAttribute("brands", list);
        return "brand-list";
    }

}
