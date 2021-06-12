package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository repository;

    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    public Stock getStockById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Stock getStockByPurchaseId(Long purchaseId) {
        return repository.getStockByPurchaseId(purchaseId);
    }

    public List<Stock> getAllByPurchaseIdIn(List<Long> purchaseIdList) {
        return repository.getAllByPurchaseIdIn(purchaseIdList);
    }

    public Stock createStock(Stock stock){
        return repository.save(stock);
    }

    public Stock updateStock(Stock newStock, Long id)
    {
        return repository.findById(id)
                .map(stock -> {
                    stock.setPurchase(newStock.getPurchase());
                    stock.setLocation(newStock.getLocation());
                    stock.setQuantity(newStock.getQuantity());
                    return repository.save(stock);
                })
                .orElseGet(() -> {
                    newStock.setId(id);
                    return repository.save(newStock);
                });
    }

    public ResponseEntity<Object> deleteStockById(Long id){
        repository.deleteById(id);
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
        } else return ResponseEntity.ok().body("Stock is Deleted Successfully");
    }

    public Long countExpiredStock(){
        return repository.countExpiredStock();
    }

    public List<Stock> getOutOfStock(){
        return repository.getOutOfStock();
    }
}
