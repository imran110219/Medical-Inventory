package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.GenericDTO;
import com.sadman.medicalinventory.dto.IndicationDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import com.sadman.medicalinventory.repository.GenericRepository;
import com.sadman.medicalinventory.repository.IndicationGenericRepository;
import com.sadman.medicalinventory.repository.IndicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class IndicationService {

    @Autowired
    IndicationRepository repository;

    @Autowired
    GenericRepository genericRepository;

    @Autowired
    IndicationGenericRepository indicationGenericRepository;

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

    public Indication createIndication(Indication indication){
        return repository.save(indication);
    }

    public Indication updateIndication(Indication newIndication, Long id) {
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

    @Transactional
    public void updateIndicationDTO(IndicationDTO newIndicationDTO, Long id) {
        Indication newIndication = new Indication();
        newIndication.setName(newIndicationDTO.getName());
        newIndication.setDescription(newIndicationDTO.getDescription());
        Indication indication = updateIndication(newIndication, id);
        indicationGenericRepository.deleteIndicationGenericsByIndicationId(id);
        List<IndicationGeneric> indicationGenericList = new ArrayList<>();
        for (int i = 0; i < newIndicationDTO.getGenericIds().size(); i++) {
            Generic generic = genericRepository.getOne(newIndicationDTO.getGenericIds().get(i));
            IndicationGeneric indicationGeneric = new IndicationGeneric(indication,generic);
            indicationGenericList.add(indicationGeneric);
        }
        indicationGenericRepository.saveAll(indicationGenericList);
    }

    @Transactional
    public ResponseEntity<Object> deleteIndicationById(Long id){
        if(repository.findById(id).isPresent()){
            if(repository.getOne(id).getGenerics().size() == 0) {
                repository.deleteById(id);
                if (repository.findById(id).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
                } else return ResponseEntity.ok().body("Successfully deleted specified record");
            } else {
                indicationGenericRepository.deleteIndicationGenericsByIndicationId(id);
                indicationGenericRepository.flush();
                repository.deleteById(id);
                return ResponseEntity.ok().body("Successfully deleted specified record");
            }
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

}
