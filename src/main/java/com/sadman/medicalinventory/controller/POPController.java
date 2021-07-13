package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.dto.PurchaseInvoiceDTO;
import com.sadman.medicalinventory.dto.PurchaseMedicineDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.*;
import com.sadman.medicalinventory.model.*;
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
    BrandService brandService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    StockService stockService;

    @Autowired
    POPService popService;

    @Autowired
    PurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    SaleService saleService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    BoxService boxService;

    @Autowired
    LocationService locationService;

    @PostMapping(value="/pop/manufacturer/{id}")
    public ResponseEntity<List<Brand>> getPurchasesByBrandId(@PathVariable(value = "id") Long manufacturerId){
        List<Brand> brandList = brandService.getBrandsByManufacturerId(manufacturerId);
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }

    @RequestMapping(value = "/pop")
    public String getPOP(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        List<Supplier> supplierList = supplierService.getAllSuppliers();
        List<Box> boxList = boxService.getAllBoxes();
        List<Location> locationList = locationService.getAllLocations();
        List<Manufacturer> manufacturerList = manufacturerService.getAllManufacturers();
        List<PurchaseMedicineDTO> purchaseMedicineDTOList = new ArrayList<>();
        PurchaseInvoiceDTO purchaseInvoiceDTO = new PurchaseInvoiceDTO();
        purchaseInvoiceDTO.setPurchaseMedicineDTOList(purchaseMedicineDTOList);
        model.addAttribute("medicinedto", new MedicineDTO());
        model.addAttribute("suppliers",supplierList);
        model.addAttribute("manufacturers",manufacturerList);
        model.addAttribute("boxes",boxList);
        model.addAttribute("locations",locationList);
        model.addAttribute("purchaseinvoicedto", purchaseInvoiceDTO);
        model.addAttribute("brands", brandList);
        return "pop";
    }

    @PostMapping(value="/pop/payment")
    public ResponseEntity<PurchaseInvoice> makePayment(PurchaseInvoiceDTO purchaseInvoiceDTO){
        PurchaseInvoice purchaseInvoice = popService.makePayment(purchaseInvoiceDTO);
        return new ResponseEntity<>(purchaseInvoice, HttpStatus.OK);
    }

    @GetMapping(value = "/pop/invoice/{invoiceId}")
    public String getInvoice(Model model, @PathVariable(value = "invoiceId") String purchaseInvoiceId) throws RecordNotFoundException {
        PurchaseInvoice purchaseInvoice = purchaseInvoiceService.getPurchaseInvoiceById(purchaseInvoiceId);
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(purchaseInvoiceId);
        model.addAttribute("invoice", purchaseInvoice);
        model.addAttribute("purchaseList", purchaseList);
        return "invoice/purchase-invoice";
    }

    @GetMapping(value = "/pop/invoice/{invoiceId}/print")
    public String printInvoice(Model model, @PathVariable(value = "invoiceId") String purchaseInvoiceId) throws RecordNotFoundException {
        PurchaseInvoice purchaseInvoice = purchaseInvoiceService.getPurchaseInvoiceById(purchaseInvoiceId);
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(purchaseInvoiceId);
        model.addAttribute("invoice", purchaseInvoice);
        model.addAttribute("purchaseList", purchaseList);
        return "invoice/purchase-invoice-print";
    }
}
