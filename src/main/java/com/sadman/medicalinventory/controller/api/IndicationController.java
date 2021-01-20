package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.service.GenericService;
import com.sadman.medicalinventory.service.IndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndicationController {
    @Autowired
    IndicationService service;

    @GetMapping("/indications")
    public List<Indication> getAllIndications(Model model)
    {
        return service.getAllIndications();
    }

    @GetMapping("/indications/{id}")
    public ResponseEntity<Indication> getIndicationById(@PathVariable(value = "id") Long indicationId)
            throws RecordNotFoundException {
        Indication indication = service.getIndicationById(indicationId);
        return ResponseEntity.ok().body(indication);
    }

    @PostMapping("/indications")
    public Indication createIndication(@Valid @RequestBody Indication indication) {
        return service.createIndication(indication);
    }

    @PutMapping("/indications/edit/{id}")
    public Indication editIndicationById(@RequestBody Indication newIndication, @PathVariable(value = "id") Long indicationId) {
        return service.updateIndication(newIndication, indicationId);
    }

    @DeleteMapping("/indications/delete/{id}")
    public void deleteIndicationById(@PathVariable(value = "id") Long indicationId){
        service.deleteIndicationById(indicationId);
    }
}
