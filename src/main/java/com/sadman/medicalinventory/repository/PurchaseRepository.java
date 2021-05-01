package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> getPurchasesByBrandId(Long brandId);
    List<Purchase> getPurchasesByPurchaseInvoiceId(String purchaseInvoiceId);
}
