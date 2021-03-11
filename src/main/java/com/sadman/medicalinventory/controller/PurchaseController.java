package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService service;
    
    @RequestMapping(value = "/purchases")
    public String getAllUsers(Model model) {
        List<Purchase> list = service.getAllPurchases();
        model.addAttribute("purchases", list);
        return "purchase-list";
    }

}
