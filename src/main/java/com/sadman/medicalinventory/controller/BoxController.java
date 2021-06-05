package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Box;
import com.sadman.medicalinventory.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoxController {

    @Autowired
    private BoxService service;

    @RequestMapping(value = "/boxes")
    public String getAllBoxs(Model model) {
        List<Box> list = service.getAllBoxes();
        model.addAttribute("box", new Box());
        model.addAttribute("boxes", list);
        return "box-list";
    }

    @GetMapping("/boxes/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable(value = "id") Long dosageFormId)
            throws RecordNotFoundException {
        Box dosageForm = service.getBoxById(dosageFormId);
        return ResponseEntity.ok(dosageForm);
    }

    @PostMapping(value="/boxes/add")
    public ResponseEntity<String> addBox(Box dosageForm){
        service.createBox(dosageForm);
        return new ResponseEntity<>("Dosage Form is added successfully", HttpStatus.OK);
    }

    @PutMapping("/boxes/edit/{id}")
    public ResponseEntity<String> editBoxById(@RequestBody Box newBox, @PathVariable(value = "id") Long dosageFormId) {
        service.updateBox(newBox, dosageFormId);
        return new ResponseEntity<>("Dosage Form is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/boxes/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBoxById(@PathVariable(value = "id") Long dosageFormId){
        service.deleteBoxById(dosageFormId);
        return new ResponseEntity<>("Dosage Form is Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping(value="/boxes/checkName")
    public ResponseEntity<Boolean> checkName(String name){
        boolean isName = !service.existsByName(name);
        return new ResponseEntity<>(isName, HttpStatus.OK);
    }
}
