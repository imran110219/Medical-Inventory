package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService service;
    
    @RequestMapping(value = "/invoices")
    public String getAllUsers(Model model) {
        List<SaleInvoice> list = service.getAllInvoices();
        model.addAttribute("invoices", list);
        return "invoice-list";
    }

}
