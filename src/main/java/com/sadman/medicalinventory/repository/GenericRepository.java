package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Generic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<Generic, Long> {
    boolean existsByName(String name);
}
