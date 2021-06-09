package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock getStockByPurchaseId(Long purchaseId);
    List<Stock> getAllByPurchaseIdIn(List<Long> purchaseIdList);

    @Query("SELECT purchase.id FROM Stock")
    List<Long> findPurchaseIdsInStock();
}