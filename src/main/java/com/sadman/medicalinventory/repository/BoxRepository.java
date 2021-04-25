package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sadman
 */
public interface BoxRepository extends JpaRepository<Box, Long> {
}
