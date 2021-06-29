package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.PurchaseInvoiceService;
import com.sadman.medicalinventory.iservice.PurchaseService;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PurchaseInvoiceController {
    @Autowired
    PurchaseInvoiceService service;

    @Autowired
    PurchaseService purchaseService;
    
    @RequestMapping(value = "/purchaseinvoices")
    public String getAllUsers(Model model) {
        List<PurchaseInvoice> list = service.getAllPurchaseInvoices();
        model.addAttribute("purchaseinvoices", list);
        return "purchase-invoice-list";
    }

    @GetMapping(value = "/purchaseinvoices/{invoiceId}")
    public String getInvoice(Model model, @PathVariable(value = "invoiceId") String purchaseInvoiceId) throws RecordNotFoundException {
        PurchaseInvoice purchaseInvoice = service.getPurchaseInvoiceById(purchaseInvoiceId);
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(purchaseInvoiceId);
        model.addAttribute("invoice", purchaseInvoice);
        model.addAttribute("purchaseList", purchaseList);
        return "invoice/purchase-invoice";
    }

}
