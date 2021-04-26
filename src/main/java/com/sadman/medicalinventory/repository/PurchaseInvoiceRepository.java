package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import com.sadman.medicalinventory.model.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, String> {
}
