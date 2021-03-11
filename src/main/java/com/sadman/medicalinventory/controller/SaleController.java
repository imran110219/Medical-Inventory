package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SaleController {
    @Autowired
    private SaleService service;

    @RequestMapping(value = "/sales")
    public String getAllSales(Model model) {
        List<Sale> list = service.getAllSales();
        model.addAttribute("sales", list);
        return "sale-list";
    }
}
