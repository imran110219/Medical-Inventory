package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.ReturnListDTO;
import com.sadman.medicalinventory.iservice.*;
import com.sadman.medicalinventory.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
@Controller
public class ReturnController {
    @Autowired
    ReturnService service;

    @Autowired
    PurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    SaleInvoiceService saleInvoiceService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    SaleService saleService;

    @Autowired
    StockService stockService;

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
        List<Purchase> purchaseList = purchaseService.getAllPurchases();
        List<Sale> saleList = saleService.getAllSales();
        ReturnListDTO returnListDTO = new ReturnListDTO();
        model.addAttribute("sales", saleList);
        model.addAttribute("purchases", purchaseList);
        model.addAttribute("purchaseinvoices", purchaseInvoiceList);
        model.addAttribute("saleinvoices", saleInvoiceList);
        model.addAttribute("returns", returnListDTO);
        return "return/add-return";
    }

    @PostMapping(value="/returns/purchases/{id}")
    public ResponseEntity<List<Stock>> getPurchasesByPurchaseInvoiceId(@PathVariable(value = "id") String invoiceId){
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(invoiceId);
        List<Long> purchaseIdList = purchaseList.stream()
                .map(Purchase::getId)
                .collect(Collectors.toList());
        List<Stock> stockList = stockService.getAllByPurchaseIdIn(purchaseIdList);
        return new ResponseEntity<>(stockList, HttpStatus.OK);
    }

    @PostMapping(value="/returns/sales/{id}")
    public ResponseEntity<List<Sale>> getSalesBySaleInvoiceId(@PathVariable(value = "id") String invoiceId){
        List<Sale> saleList = saleService.getAllSalesBySaleInvoiceId(invoiceId);
        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }

    @PostMapping(value="/returns/process")
    public ResponseEntity<String> returnProcess(ReturnListDTO returnListDTO){
        service.returnProcess(returnListDTO);
        return new ResponseEntity<>("Return is processed successfully", HttpStatus.OK);
    }
}
