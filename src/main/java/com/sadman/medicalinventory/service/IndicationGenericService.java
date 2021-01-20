package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import com.sadman.medicalinventory.repository.IndicationGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicationGenericService {
    @Autowired
    IndicationGenericRepository repository;

    public List<IndicationGeneric> getAllIndicationGenerics() {
        return repository.findAll();
    }

    public List<IndicationGeneric> getIndicationsByGenericId(Long genericId)
    {
        return repository.getIndicationsByGenericId(genericId);
    }

    public List<IndicationGeneric> getGenericsByIndicationId(Long indicationId)
    {
        return repository.getGenericsByIndicationId(indicationId);
    }

    public IndicationGeneric getIndicationGenericById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public IndicationGeneric createIndicationGeneric(IndicationGeneric indicationGeneric) {
        return repository.save(indicationGeneric);
    }

    public IndicationGeneric updateIndicationGeneric(IndicationGeneric newIndicationGeneric, Long id) {
        return repository.findById(id)
                .map(indicationGeneric -> {
                    indicationGeneric.setIndication(newIndicationGeneric.getIndication());
                    indicationGeneric.setGeneric(newIndicationGeneric.getGeneric());
                    return repository.save(indicationGeneric);
                })
                .orElseGet(() -> {
                    newIndicationGeneric.setId(id);
                    return repository.save(newIndicationGeneric);
                });
    }

    public void deleteIndicationGenericById(Long id) {
        repository.deleteById(id);
    }
}