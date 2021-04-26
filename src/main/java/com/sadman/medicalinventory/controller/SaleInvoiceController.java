package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.service.SaleInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SaleInvoiceController {
    @Autowired
    private SaleInvoiceService service;
    
    @RequestMapping(value = "/saleinvoices")
    public String getAllUsers(Model model) {
        List<SaleInvoice> list = service.getAllSaleInvoices();
        model.addAttribute("saleinvoices", list);
        return "sale-invoice-list";
    }

}
