package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.IndicationGeneric;

import java.util.List;

/**
 * @author Sadman
 */
public interface IndicationGenericService {
    List<IndicationGeneric> getAllIndicationGenerics();

    IndicationGeneric getIndicationGenericById(Long id) throws RecordNotFoundException;

    IndicationGeneric createIndicationGeneric(IndicationGeneric indicationGeneric);

    IndicationGeneric updateIndicationGeneric(IndicationGeneric newIndicationGeneric, Long id);

    void deleteIndicationGenericById(Long id);
}
