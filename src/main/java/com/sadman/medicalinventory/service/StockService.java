package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository repository;

    public List<Stock> getAllStocks()
    {
        return repository.findAll();
    }

    public Stock getStockById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Stock createStock(Stock stock){
        return repository.save(stock);
    }

    public Stock updateStock(Stock newStock, Long id)
    {
        return repository.findById(id)
                .map(stock -> {
                    stock.setPurchase(newStock.getPurchase());
                    stock.setQuantity(newStock.getQuantity());
                    stock.setExpiredDate(newStock.getExpiredDate());
                    return repository.save(stock);
                })
                .orElseGet(() -> {
                    newStock.setId(id);
                    return repository.save(newStock);
                });
    }

    public void deleteStockById(Long id){
        repository.deleteById(id);
    }
}
