package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.dto.PurchaseInvoiceDTO;
import com.sadman.medicalinventory.dto.PurchaseMedicineDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Controller
public class POPController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private StockService stockService;

    @Autowired
    private POSService posService;

    @Autowired
    private SaleInvoiceService saleInvoiceService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SupplierService supplierService;

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

    @RequestMapping(value = "/pop")
    public String getPOP(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        List<Supplier> supplierList = supplierService.getAllSuppliers();
        List<PurchaseMedicineDTO> purchaseMedicineDTOList = new ArrayList<>();
        PurchaseInvoiceDTO purchaseInvoiceDTO = new PurchaseInvoiceDTO();
        purchaseInvoiceDTO.setPurchaseMedicineDTOList(purchaseMedicineDTOList);
        model.addAttribute("medicinedto", new MedicineDTO());
        model.addAttribute("suppliers",supplierList);
        model.addAttribute("purchaseinvoicedto", purchaseInvoiceDTO);
        model.addAttribute("brands", brandList);
        return "pop";
    }

    @PostMapping(value="/pos/payment")
    public ResponseEntity<SaleInvoice> makePayment(InvoiceDTO invoiceDTO){
        SaleInvoice invoice = posService.makePayment(invoiceDTO);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping(value = "/pos/invoice/{invoiceId}")
    public String getInvoice(Model model, @PathVariable(value = "invoiceId") String saleInvoiceId) throws RecordNotFoundException {
        SaleInvoice saleInvoice = saleInvoiceService.getSaleInvoiceById(saleInvoiceId);
        List<Sale> saleList = saleService.getAllSalesBySaleInvoiceId(saleInvoiceId);
        model.addAttribute("invoice", saleInvoice);
        model.addAttribute("saleList", saleList);
        return "invoice/invoice";
    }

    @GetMapping(value = "/pos/invoice/{invoiceId}/print")
    public String printInvoice(Model model, @PathVariable(value = "invoiceId") String saleInvoiceId) throws RecordNotFoundException {
        SaleInvoice saleInvoice = saleInvoiceService.getSaleInvoiceById(saleInvoiceId);
        List<Sale> saleList = saleService.getAllSalesBySaleInvoiceId(saleInvoiceId);
        model.addAttribute("invoice", saleInvoice);
        model.addAttribute("saleList", saleList);
        return "invoice/invoice-print";
    }
}
