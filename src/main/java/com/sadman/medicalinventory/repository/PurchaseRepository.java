package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> getPurchasesByBrandId(Long brandId);
    List<Purchase> findAllByPurchaseInvoiceId(String purchaseInvoiceId);

    @Query("SELECT p FROM Purchase p WHERE p.id NOT IN :idList")
    List<Purchase> findAllByIdNotContains(@Param("idList") List<Long> ids);
}
