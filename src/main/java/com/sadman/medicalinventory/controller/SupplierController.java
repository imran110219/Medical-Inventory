package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Supplier;
import com.sadman.medicalinventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService service;
    
    @RequestMapping(value = "/suppliers")
    public String getAllUsers(Model model) {
        List<Supplier> list = service.getAllSuppliers();
        model.addAttribute("suppliers", list);
        return "supplier-list";
    }

}
