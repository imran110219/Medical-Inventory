package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GenericService {
    @Autowired
    GenericRepository repository;

    public List<Generic> getAllGenerics()
    {
        return repository.findAll();
    }

    public Generic getGenericById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Indication> getIndicationsByGenericId(Long id) throws RecordNotFoundException {
        Generic generic = getGenericById(id);
        Set<Indication> indicationSet = generic.getIndications();
        return new ArrayList<>(indicationSet);
    }

    public Generic createGeneric(Generic generic){
        return repository.save(generic);
    }

    public Generic updateGeneric(Generic newGeneric, Long id)
    {
        return repository.findById(id)
                .map(generic -> {
                    generic.setName(newGeneric.getName());
                    generic.setDescription(newGeneric.getDescription());
                    return repository.save(generic);
                })
                .orElseGet(() -> {
                    newGeneric.setId(id);
                    return repository.save(newGeneric);
                });
    }

    public void deleteGenericById(Long id){
        repository.deleteById(id);
    }
}
