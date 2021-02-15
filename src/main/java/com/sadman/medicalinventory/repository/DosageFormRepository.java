package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.DosageForm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sadman
 */
public interface DosageFormRepository  extends JpaRepository<DosageForm, Long> {
}
