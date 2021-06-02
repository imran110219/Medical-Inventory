package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.repository.GenericRepository;
import com.sadman.medicalinventory.repository.IndicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class IndicationService {
    @Autowired
    IndicationRepository repository;

    public List<Indication> getAllIndications() {
        return repository.findAll();
    }

    public Indication getIndicationById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Generic> getGenericsByIndicationId(Long id) throws RecordNotFoundException {
        Indication indication = getIndicationById(id);
        Set<Generic> genericSet = indication.getGenerics();
        return new ArrayList<>(genericSet);
    }

//    public List<Generic> getGenericsByIndicationId(Long id) throws RecordNotFoundException {
//        return repository.getGenericsById(id);
//    }

    public Indication createIndication(Indication indication){
        return repository.save(indication);
    }

    public Indication updateIndication(Indication newIndication, Long id)
    {
        return repository.findById(id)
                .map(indication -> {
                    indication.setName(newIndication.getName());
                    indication.setDescription(newIndication.getDescription());
                    return repository.save(indication);
                })
                .orElseGet(() -> {
                    newIndication.setId(id);
                    return repository.save(newIndication);
                });
    }

    public void deleteIndicationById(Long id){
        repository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

}
