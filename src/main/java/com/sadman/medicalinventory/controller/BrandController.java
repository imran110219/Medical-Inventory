package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Manufacturer;
import com.sadman.medicalinventory.service.BrandService;
import com.sadman.medicalinventory.service.DosageFormService;
import com.sadman.medicalinventory.service.GenericService;
import com.sadman.medicalinventory.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private DosageFormService dosageFormService;

    @Autowired
    private GenericService genericService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/brands")
    public String getAllUsers(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        List<DosageForm> dosageFormList = dosageFormService.getAllDosageForms();
        List<Generic> genericList = genericService.getAllGenerics();
        List<Manufacturer> manufacturerList = manufacturerService.getAllManufacturers();
        model.addAttribute("dosageforms", dosageFormList);
        model.addAttribute("generics", genericList);
        model.addAttribute("manufacturers", manufacturerList);
        model.addAttribute("brands", brandList);
        return "brand-list";
    }

}
