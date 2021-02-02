package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
