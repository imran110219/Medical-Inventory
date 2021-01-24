package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, String> {
}
