package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Stock;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sadman
 */
public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id) throws RecordNotFoundException;

    Stock getStockByPurchaseId(Long purchaseId);

    List<Stock> getAllByPurchaseIdIn(List<Long> purchaseIdList);

    Stock createStock(Stock stock);

    Stock updateStock(Stock newStock, Long id);

    ResponseEntity<Object> deleteStockById(Long id);

    List<Stock> getExpiredStock();

    List<Stock> getOutOfStock();
}
