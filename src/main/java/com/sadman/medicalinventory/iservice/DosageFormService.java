package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.DosageForm;

import java.util.List;

/**
 * @author Sadman
 */
public interface DosageFormService {
    List<DosageForm> getAllDosageForms();

    DosageForm getDosageFormById(Long id) throws RecordNotFoundException;

    DosageForm createDosageForm(DosageForm dosageForm);

    DosageForm updateDosageForm(DosageForm newDosageForm, Long id);

    void deleteDosageFormById(Long id);

    boolean existsByName(String name);
}
