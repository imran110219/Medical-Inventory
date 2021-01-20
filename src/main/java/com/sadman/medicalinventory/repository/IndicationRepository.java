package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Indication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicationRepository extends JpaRepository<Indication, Long> {
}
