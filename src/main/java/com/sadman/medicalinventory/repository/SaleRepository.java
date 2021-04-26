package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllBySaleInvoiceId(String saleInvoiceId);
}
