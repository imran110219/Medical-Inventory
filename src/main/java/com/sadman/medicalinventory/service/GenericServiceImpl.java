package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.GenericDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.GenericService;
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
public class GenericServiceImpl implements GenericService {
    @Autowired
    GenericRepository repository;

    @Autowired
    IndicationRepository indicationRepository;

    @Autowired
    IndicationGenericRepository indicationGenericRepository;

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

    public Generic updateGeneric(Generic newGeneric, Long id) {
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

//    @Transactional
    public void updateGenericDTO(GenericDTO newGenericDTO, Long id) {
        Generic newGeneric = new Generic();
        newGeneric.setName(newGenericDTO.getName());
        newGeneric.setDescription(newGenericDTO.getDescription());
        Generic generic = updateGeneric(newGeneric, id);
//        indicationGenericRepository.deleteIndicationGenericsByGenericId(id);
//        List<IndicationGeneric> indicationGenericList = new ArrayList<>();
//        for (int i = 0; i < newGeneriDTO.getIndicationIds().size(); i++) {
//            Indication indication = indicationRepository.getOne(newGeneriDTO.getIndicationIds().get(i));
//            IndicationGeneric indicationGeneric = new IndicationGeneric(indication,generic);
//            indicationGenericList.add(indicationGeneric);
//        }
//        indicationGenericRepository.saveAll(indicationGenericList);
    }

    public ResponseEntity<Object> deleteGenericById(Long id){
        if(repository.findById(id).isPresent()){
            if(repository.getOne(id).getIndications().size() == 0) {
                repository.deleteById(id);
                if (repository.findById(id).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
                } else return ResponseEntity.ok().body("Successfully deleted specified record");
            } else return ResponseEntity.unprocessableEntity().body("Failed to delete, Please delete this generic from indication");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
