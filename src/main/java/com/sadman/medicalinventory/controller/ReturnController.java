package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.service.PurchaseInvoiceService;
import com.sadman.medicalinventory.service.PurchaseService;
import com.sadman.medicalinventory.service.ReturnService;
import com.sadman.medicalinventory.service.SaleInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Controller
public class ReturnController {
    @Autowired
    private ReturnService service;

    @Autowired
    private PurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    private SaleInvoiceService saleInvoiceService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/returns")
    public String getAllReturns(Model model) {
        List<Return> list = service.getAllReturns();
        model.addAttribute("returns", list);
        return "return-list";
    }

    @RequestMapping(value = "/returns/add")
    public String addReturn(Model model) {
        List<PurchaseInvoice> purchaseInvoiceList = purchaseInvoiceService.getAllPurchaseInvoices();
        List<SaleInvoice> saleInvoiceList = saleInvoiceService.getAllSaleInvoices();
        model.addAttribute("purchaseinvoices", purchaseInvoiceList);
        model.addAttribute("saleinvoices", saleInvoiceList);
        return "return/add-return";
    }

    @PostMapping(value="/returns/purchases/{id}")
    public ResponseEntity<List<Purchase>> getPurchasesByPurchaseInvoiceId(@PathVariable(value = "id") String invoiceId){
        List<Purchase> PurchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(invoiceId);
        return new ResponseEntity<>(PurchaseList, HttpStatus.OK);
    }
}
