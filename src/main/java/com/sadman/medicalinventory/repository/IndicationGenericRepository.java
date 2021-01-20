package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicationGenericRepository extends JpaRepository<IndicationGeneric, Long> {
    public List<IndicationGeneric> getIndicationsByGenericId(Long genericId);
    public List<IndicationGeneric> getGenericsByIndicationId(Long indicationId);
}
