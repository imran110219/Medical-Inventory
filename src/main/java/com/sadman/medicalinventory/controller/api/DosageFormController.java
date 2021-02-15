package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.service.DosageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DosageFormController {
    @Autowired
    private DosageFormService service;

    @GetMapping("/dosageForms")
    public List<DosageForm> getAllDosageForms(Model model) {
        return service.getAllDosageForms();
    }

    @GetMapping("/dosageForms/{id}")
    public ResponseEntity<DosageForm> getDosageFormById(@PathVariable(value = "id") Long dosageFormId)
            throws RecordNotFoundException {
        DosageForm DosageForm = service.getDosageFormById(dosageFormId);
        return ResponseEntity.ok().body(DosageForm);
    }

    @PostMapping("/dosageForms")
    public DosageForm createDosageForm(@Valid @RequestBody DosageForm dosageForm) {
        return service.createDosageForm(dosageForm);
    }

    @PutMapping("/dosageForms/edit/{id}")
    public DosageForm editDosageFormById(@RequestBody DosageForm newDosageForm, @PathVariable(value = "id") Long dosageFormId) {
        return service.updateDosageForm(newDosageForm, dosageFormId);
    }

    @DeleteMapping("/dosageForms/delete/{id}")
    public void deleteDosageFormById(@PathVariable(value = "id") Long dosageFormId){
        service.deleteDosageFormById(dosageFormId);
    }
}
