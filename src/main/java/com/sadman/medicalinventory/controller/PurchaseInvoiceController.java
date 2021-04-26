package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.PurchaseInvoice;
import com.sadman.medicalinventory.service.PurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PurchaseInvoiceController {
    @Autowired
    private PurchaseInvoiceService service;
    
    @RequestMapping(value = "/purchaseinvoices")
    public String getAllUsers(Model model) {
        List<PurchaseInvoice> list = service.getAllPurchaseInvoices();
        model.addAttribute("purchaseinvoices", list);
        return "purchase-invoice-list";
    }

}
