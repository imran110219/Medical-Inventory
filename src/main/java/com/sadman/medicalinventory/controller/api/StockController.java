package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {
    @Autowired
    StockService service;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks(Model model)
    {
        return service.getAllStocks();
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Long stockId)
            throws RecordNotFoundException {
        Stock stock = service.getStockById(stockId);
        return ResponseEntity.ok().body(stock);
    }

    @PostMapping("/stocks")
    public Stock createStock(@Valid @RequestBody Stock stock) {
        return service.createStock(stock);
    }

    @PutMapping("/stocks/edit/{id}")
    public Stock editStockById(@RequestBody Stock newStock, @PathVariable(value = "id") Long stockId) {
        return service.updateStock(newStock, stockId);
    }

    @DeleteMapping("/stocks/delete/{id}")
    public void deleteStockById(@PathVariable(value = "id") Long stockId){
        service.deleteStockById(stockId);
    }
}

