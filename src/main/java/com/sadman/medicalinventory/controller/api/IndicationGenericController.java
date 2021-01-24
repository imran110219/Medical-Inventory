package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.IndicationGeneric;
import com.sadman.medicalinventory.service.IndicationGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndicationGenericController {
    @Autowired
    IndicationGenericService service;

    @GetMapping("/indicationgenerics")
    public List<IndicationGeneric> getAllIndicationGenerics(Model model)
    {
        return service.getAllIndicationGenerics();
    }

    @GetMapping("/indicationgenerics/{id}")
    public ResponseEntity<IndicationGeneric> getIndicationGenericById(@PathVariable(value = "id") Long indicationGenericId)
            throws RecordNotFoundException {
        IndicationGeneric indicationGeneric = service.getIndicationGenericById(indicationGenericId);
        return ResponseEntity.ok().body(indicationGeneric);
    }

    @PostMapping("/indicationgenerics")
    public IndicationGeneric createIndicationGeneric(@Valid @RequestBody IndicationGeneric indicationGeneric) {
        return service.createIndicationGeneric(indicationGeneric);
    }

    @PutMapping("/indicationgenerics/edit/{id}")
    public IndicationGeneric editIndicationGenericById(@RequestBody IndicationGeneric newIndicationGeneric, @PathVariable(value = "id") Long indicationGenericId) {
        return service.updateIndicationGeneric(newIndicationGeneric, indicationGenericId);
    }

    @DeleteMapping("/indicationgenerics/delete/{id}")
    public void deleteIndicationGenericById(@PathVariable(value = "id") Long indicationGenericId){
        service.deleteIndicationGenericById(indicationGenericId);
    }
}
