package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.repository.DosageFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosageFormService {
    @Autowired
    DosageFormRepository repository;

    public List<DosageForm> getAllDosageForms() {
        return repository.findAll();
    }

    public DosageForm getDosageFormById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public DosageForm createDosageForm(DosageForm dosageForm){
        return repository.save(dosageForm);
    }

    public DosageForm updateDosageForm(DosageForm newDosageForm, Long id)
    {
        return repository.findById(id)
                .map(dosageForm -> {
                    dosageForm.setName(newDosageForm.getName());
                    return repository.save(dosageForm);
                })
                .orElseGet(() -> {
                    newDosageForm.setId(id);
                    return repository.save(newDosageForm);
                });
    }

    public void deleteDosageFormById(Long id){
        repository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
