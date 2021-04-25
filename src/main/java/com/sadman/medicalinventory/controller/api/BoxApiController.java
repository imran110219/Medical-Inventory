package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Box;
import com.sadman.medicalinventory.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoxApiController {
    @Autowired
    private BoxService service;

    @GetMapping("/boxes")
    public List<Box> getAllBoxes(Model model) {
        return service.getAllBoxes();
    }

    @GetMapping("/boxes/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable(value = "id") Long dosageFormId)
            throws RecordNotFoundException {
        Box Box = service.getBoxById(dosageFormId);
        return ResponseEntity.ok().body(Box);
    }

    @PostMapping("/boxes")
    public Box createBox(@Valid @RequestBody Box dosageForm) {
        return service.createBox(dosageForm);
    }

    @PutMapping("/boxes/edit/{id}")
    public Box editBoxById(@RequestBody Box newBox, @PathVariable(value = "id") Long dosageFormId) {
        return service.updateBox(newBox, dosageFormId);
    }

    @DeleteMapping("/boxes/delete/{id}")
    public void deleteBoxById(@PathVariable(value = "id") Long dosageFormId){
        service.deleteBoxById(dosageFormId);
    }
}
