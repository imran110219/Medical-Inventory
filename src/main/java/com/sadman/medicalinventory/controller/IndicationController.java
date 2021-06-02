package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.GenericDTO;
import com.sadman.medicalinventory.dto.IndicationDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.GenericService;
import com.sadman.medicalinventory.service.IndicationService;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndicationController {

    @Autowired
    private IndicationService service;

    @Autowired
    private GenericService genericService;

    @RequestMapping(value = "/indications")
    public String getAllIndications(Model model) {
        List<Indication> list = service.getAllIndications();
        List<Generic> genericList = genericService.getAllGenerics();
        model.addAttribute("indication", new Indication());
        model.addAttribute("indicationdto", new IndicationDTO());
        model.addAttribute("indications", list);
        model.addAttribute("generics", genericList);
        return "indication-list";
    }

    @GetMapping("/indications/{id}")
    public ResponseEntity<Indication> getIndicationById(@PathVariable(value = "id") Long indicationId)
            throws RecordNotFoundException {
        Indication indication = service.getIndicationById(indicationId);
        return ResponseEntity.ok(indication);
    }

    @PostMapping(value="/indications/add")
    public ResponseEntity<String> addGeneric(Indication indication){
        service.createIndication(indication);
        return new ResponseEntity<>("Indication is added successfully", HttpStatus.OK);
    }

    @PutMapping("/indications/edit/{id}")
    public ResponseEntity<String> editGenericById(@RequestBody IndicationDTO newIndicationDTO, @PathVariable(value = "id") Long indicationId) {
        service.updateIndicationDTO(newIndicationDTO, indicationId);
        return new ResponseEntity<>("Indication is Edited Successfully", HttpStatus.OK);
    }

    @PostMapping(value="/indications/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
