package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.GenericDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 */
public interface GenericService {
    List<Generic> getAllGenerics();

    Generic getGenericById(Long id) throws RecordNotFoundException;

    List<Indication> getIndicationsByGenericId(Long id) throws RecordNotFoundException;

    Generic createGeneric(Generic generic);

    Generic updateGeneric(Generic newGeneric, Long id);
    
    void updateGenericDTO(GenericDTO newGenericDTO, Long id);

    ResponseEntity<Object> deleteGenericById(Long id);

    boolean existsByName(String name);
}
