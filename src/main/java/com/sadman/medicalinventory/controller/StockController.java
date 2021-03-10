package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StockController {
    @Autowired
    private StockService service;
    
    @RequestMapping(value = "/stocks")
    public String getAllUsers(Model model) {
        List<Stock> list = service.getAllStocks();
        model.addAttribute("stocks", list);
        return "stock-list";
    }

}
