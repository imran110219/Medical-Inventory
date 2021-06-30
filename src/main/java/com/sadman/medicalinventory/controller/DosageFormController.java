package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.DosageFormService;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DosageFormController {

    @Autowired
    DosageFormService service;

    @RequestMapping(value = "/dosageforms")
    public String getAllDosageForms(Model model) {
        List<DosageForm> list = service.getAllDosageForms();
        model.addAttribute("dosageform", new DosageForm());
        model.addAttribute("dosageforms", list);
        return "dosageform-list";
    }

    @GetMapping("/dosageforms/{id}")
    public ResponseEntity<DosageForm> getDosageFormById(@PathVariable(value = "id") Long dosageFormId)
            throws RecordNotFoundException {
        DosageForm dosageForm = service.getDosageFormById(dosageFormId);
        return ResponseEntity.ok(dosageForm);
    }

    @PostMapping(value="/dosageforms/add")
    public ResponseEntity<String> addDosageForm(DosageForm dosageForm){
        service.createDosageForm(dosageForm);
        return new ResponseEntity<>("Dosage Form is added successfully", HttpStatus.OK);
    }

    @PutMapping("/dosageforms/edit/{id}")
    public ResponseEntity<String> editDosageFormById(@RequestBody DosageForm newDosageForm, @PathVariable(value = "id") Long dosageFormId) {
        service.updateDosageForm(newDosageForm, dosageFormId);
        return new ResponseEntity<>("Dosage Form is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/dosageforms/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteDosageFormById(@PathVariable(value = "id") Long dosageFormId){
        service.deleteDosageFormById(dosageFormId);
        return new ResponseEntity<>("Dosage Form is Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping(value="/dosageforms/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }
}
