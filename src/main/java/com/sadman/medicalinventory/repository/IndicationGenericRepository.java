package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicationGenericRepository extends JpaRepository<IndicationGeneric, Long> {
    List<IndicationGeneric> getIndicationsByGenericId(Long genericId);
    List<IndicationGeneric> getGenericsByIndicationId(Long indicationId);
    void deleteIndicationGenericsByGenericId(Long genericId);
    void deleteAllByIndicationId(Long indicationId);
}
