package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.service.LocationService;
import com.sadman.medicalinventory.service.PurchaseService;
import com.sadman.medicalinventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
public class StockController {

    @Autowired
    private StockService service;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    LocationService locationService;
    
    @RequestMapping(value = "/stocks")
    public String getAllStocks(Model model) {
        List<Stock> list = service.getAllStocks();
        List<Purchase> purchaseList = purchaseService.getPurchasesByNotInStock();
        List<Location> locationList = locationService.getAllLocations();
        model.addAttribute("stock", new Stock());
        model.addAttribute("purchases", purchaseList);
        model.addAttribute("locations", locationList);
        model.addAttribute("stocks", list);
        return "stock-list";
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Long stockId)
            throws RecordNotFoundException {
        Stock stock = service.getStockById(stockId);
        return ResponseEntity.ok(stock);
    }

    @PostMapping(value="/stocks/add")
    public ResponseEntity<String> addStock(Stock stock){
        service.createStock(stock);
        return new ResponseEntity<>("Stock is added successfully", HttpStatus.OK);
    }

    @PutMapping("/stocks/edit/{id}")
    public ResponseEntity<String> editStockById(@RequestBody Stock newStock, @PathVariable(value = "id") Long stockId) {
        service.updateStock(newStock, stockId);
        return new ResponseEntity<>("Stock is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/stocks/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStockById(@PathVariable(value = "id") Long stockId){
        service.deleteStockById(stockId);
        return new ResponseEntity<>("Stock is Deleted Successfully", HttpStatus.OK);
    }

}
