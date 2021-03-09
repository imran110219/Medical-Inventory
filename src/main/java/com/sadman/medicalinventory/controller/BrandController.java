package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.service.BrandService;
import com.sadman.medicalinventory.service.DosageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService service;

    @Autowired
    private DosageFormService dosageFormService;

    @RequestMapping(value = "/brands")
    public String getAllUsers(Model model) {
        List<Brand> brandList = service.getAllBrands();
        List<DosageForm> dosageFormList = dosageFormService.getAllDosageForms();
        model.addAttribute("dosageforms", dosageFormList);
        model.addAttribute("brands", brandList);
        return "brand-list";
    }

}
