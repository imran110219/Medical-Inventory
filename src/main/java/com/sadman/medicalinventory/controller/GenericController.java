package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.GenericDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.service.GenericService;
import com.sadman.medicalinventory.service.IndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GenericController {

    @Autowired
    private GenericService service;

    @Autowired
    private IndicationService indicationService;

    @RequestMapping(value = "/generics")
    public String getAllGenerics(Model model) {
        List<Generic> list = service.getAllGenerics();
        List<Indication> indicationList = indicationService.getAllIndications();
        model.addAttribute("generic", new Generic());
        model.addAttribute("genericdto", new GenericDTO());
        model.addAttribute("generics", list);
        model.addAttribute("indications", indicationList);
        return "generic-list";
    }

    @GetMapping("/generics/{id}")
    public ResponseEntity<Generic> getGenericById(@PathVariable(value = "id") Long genericId)
            throws RecordNotFoundException {
        Generic generic = service.getGenericById(genericId);
        return ResponseEntity.ok(generic);
    }

    @PostMapping(value="/generics/add")
    public ResponseEntity<String> addGeneric(Generic generic){
        service.createGeneric(generic);
        return new ResponseEntity<>("Generic is added successfully", HttpStatus.OK);
    }

    @PutMapping("/generics/edit/{id}")
    public ResponseEntity<String> editGenericById(@RequestBody GenericDTO newGenericDTO, @PathVariable(value = "id") Long genericId) {
        service.updateGenericDTO(newGenericDTO, genericId);
        return new ResponseEntity<>("Generic is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/generics/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteGenericById(@PathVariable(value = "id") Long genericId){
        return service.deleteGenericById(genericId);
    }

    @PostMapping(value="/generics/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
