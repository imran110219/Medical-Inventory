package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.BrandService;
import com.sadman.medicalinventory.service.PurchaseService;
import com.sadman.medicalinventory.service.StockService;
import com.sadman.medicalinventory.service.UserService;
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
public class POSController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private StockService stockService;

    @PostMapping(value="/pos/brand/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable(value = "id") Long brandId) throws RecordNotFoundException {
        Brand brand = brandService.getBrandById(brandId);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping(value="/pos/purchases/{id}")
    public ResponseEntity<List<Purchase>> getPurchasesByBrandId(@PathVariable(value = "id") Long brandId){
        List<Purchase> PurchaseList = purchaseService.getPurchasesByBrandId(brandId);
        return new ResponseEntity<>(PurchaseList, HttpStatus.OK);
    }

    @PostMapping(value="/pos/stock/{id}")
    public ResponseEntity<Stock> getStockByPurchaseId(@PathVariable(value = "id") Long purchaseId){
        Stock stock = stockService.getStockByPurchaseId(purchaseId);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @RequestMapping(value = "/pos")
    public String getPOS(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        List<MedicineDTO> medicineDTOList = new ArrayList<>();
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setMedicineDTOList(medicineDTOList);
        model.addAttribute("medicinedto", new MedicineDTO());
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("brands", brandList);
        return "pos";
    }

    @PostMapping(value="/pos/payment")
    public String makePayment(InvoiceDTO invoiceDTO){
        System.out.println(invoiceDTO);
        return "invoice/invoice";
    }
}
