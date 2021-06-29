package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SaleService;
import com.sadman.medicalinventory.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleApiController {
    @Autowired
    SaleService service;

    @GetMapping("/sales")
    public List<Sale> getAllSales(Model model) {
        return service.getAllSales();
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable(value = "id") Long saleId)
            throws RecordNotFoundException {
        Sale sale = service.getSaleById(saleId);
        return ResponseEntity.ok().body(sale);
    }

    @PostMapping("/sales")
    public Sale createSale(@Valid @RequestBody Sale sale) {
        return service.createSale(sale);
    }

    @PutMapping("/sales/edit/{id}")
    public Sale editSaleById(@RequestBody Sale newSale, @PathVariable(value = "id") Long saleId) {
        return service.updateSale(newSale, saleId);
    }

    @DeleteMapping("/sales/delete/{id}")
    public void deleteSaleById(@PathVariable(value = "id") Long saleId){
        service.deleteSaleById(saleId);
    }
}
