package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.IndicationDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.GenericService;
import com.sadman.medicalinventory.iservice.IndicationService;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
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
    IndicationService service;

    @Autowired
    GenericService genericService;

    @RequestMapping(value = "/indications")
    public String getAllIndications(Model model) {
        List<Indication> list = service.getAllIndications();
        List<Generic> genericList = genericService.getAllGenerics();
        model.addAttribute("indication", new Indication());
        model.addAttribute("indicationdto", new IndicationDTO());
        model.addAttribute("indications", list);
        model.addAttribute("genericList", genericList);
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

//    @PutMapping("/indications/edit/{id}")
//    public ResponseEntity<String> editGenericById(@RequestBody Indication newIndication, @PathVariable(value = "id") Long indicationId) {
//        service.updateIndication(newIndication, indicationId);
//        return new ResponseEntity<>("Indication is Edited Successfully", HttpStatus.OK);
//    }

    @DeleteMapping("/indications/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteIndicationById(@PathVariable(value = "id") Long indicationId){
        return service.deleteIndicationById(indicationId);
    }

    @PostMapping(value="/indications/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }

}
