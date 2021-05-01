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
    private POPService popService;

    @Autowired
    private PurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private BoxService boxService;

    @Autowired
    private LocationService locationService;

//    @PostMapping(value="/pos/brand/{id}")
//    public ResponseEntity<Brand> getBrandById(@PathVariable(value = "id") Long brandId) throws RecordNotFoundException {
//        Brand brand = brandService.getBrandById(brandId);
//        return new ResponseEntity<>(brand, HttpStatus.OK);
//    }

    @PostMapping(value="/pop/manufacturer/{id}")
    public ResponseEntity<List<Brand>> getPurchasesByBrandId(@PathVariable(value = "id") Long manufacturerId){
        List<Brand> brandList = brandService.getBrandsByManufacturerId(manufacturerId);
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }

//    @PostMapping(value="/pos/stock/{id}")
//    public ResponseEntity<Stock> getStockByPurchaseId(@PathVariable(value = "id") Long purchaseId){
//        Stock stock = stockService.getStockByPurchaseId(purchaseId);
//        return new ResponseEntity<>(stock, HttpStatus.OK);
//    }

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
        PurchaseInvoice invoice = popService.makePayment(purchaseInvoiceDTO);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping(value = "/pop/invoice/{invoiceId}")
    public String getInvoice(Model model, @PathVariable(value = "invoiceId") String purchaseInvoiceId) throws RecordNotFoundException {
        PurchaseInvoice purchaseInvoice = purchaseInvoiceService.getPurchaseInvoiceById(purchaseInvoiceId);
        List<Purchase> purchaseList = purchaseService.getPurchasesByPurchaseInvoiceId(purchaseInvoiceId);
        model.addAttribute("invoice", purchaseInvoice);
        model.addAttribute("purchaseList", purchaseList);
        return "invoice/invoice";
    }

//    @GetMapping(value = "/pos/invoice/{invoiceId}/print")
//    public String printInvoice(Model model, @PathVariable(value = "invoiceId") String saleInvoiceId) throws RecordNotFoundException {
//        SaleInvoice saleInvoice = saleInvoiceService.getSaleInvoiceById(saleInvoiceId);
//        List<Sale> saleList = saleService.getAllSalesBySaleInvoiceId(saleInvoiceId);
//        model.addAttribute("invoice", saleInvoice);
//        model.addAttribute("saleList", saleList);
//        return "invoice/invoice-print";
//    }
}
