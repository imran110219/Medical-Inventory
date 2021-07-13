package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.IndicationDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 */
public interface IndicationService {
    List<Indication> getAllIndications();

    Indication getIndicationById(Long id) throws RecordNotFoundException;

    List<Generic> getGenericsByIndicationId(Long id) throws RecordNotFoundException;

    Indication createIndication(Indication indication);

    Indication updateIndication(Indication newIndication, Long id);
    
    void updateIndicationDTO(IndicationDTO newIndicationDTO, Long id);

    ResponseEntity<Object> deleteIndicationById(Long id);

    boolean existsByName(String name);
}
