package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sadman
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
