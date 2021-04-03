package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock getStockByPurchaseId(Long purchaseId);
}