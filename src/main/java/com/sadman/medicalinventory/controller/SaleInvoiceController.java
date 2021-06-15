package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.service.SaleInvoiceService;
import com.sadman.medicalinventory.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SaleInvoiceController {
    @Autowired
    private SaleInvoiceService service;

    @Autowired
    private SaleService saleService;
    
    @RequestMapping(value = "/saleinvoices")
    public String getAllUsers(Model model) {
        List<SaleInvoice> list = service.getAllSaleInvoices();
        model.addAttribute("saleinvoices", list);
        return "sale-invoice-list";
    }

    @GetMapping(value = "/saleinvoices/{invoiceId}")
    public String getInvoice(Model model, @PathVariable(value = "invoiceId") String saleInvoiceId) throws RecordNotFoundException {
        SaleInvoice saleInvoice = service.getSaleInvoiceById(saleInvoiceId);
        List<Sale> saleList = saleService.getAllSalesBySaleInvoiceId(saleInvoiceId);
        model.addAttribute("invoice", saleInvoice);
        model.addAttribute("saleList", saleList);
        return "invoice/invoice";
    }

}
