package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GenericController {
    @Autowired
    GenericService service;

    @GetMapping("/generics")
    public List<Generic> getAllGenerics(Model model) {
        return service.getAllGenerics();
    }

    @GetMapping("/generics/{id}")
    public ResponseEntity<Generic> getGenericById(@PathVariable(value = "id") Long genericId)
            throws RecordNotFoundException {
        Generic generic = service.getGenericById(genericId);
        return ResponseEntity.ok().body(generic);
    }

    @GetMapping("/generics/{id}/indications")
    public List<Indication> getIndicationsByGenericId(@PathVariable(value = "id") Long genericId)
            throws RecordNotFoundException {
        return service.getIndicationsByGenericId(genericId);
    }

    @PostMapping("/generics")
    public Generic createGeneric(@Valid @RequestBody Generic generic) {
        return service.createGeneric(generic);
    }

    @PutMapping("/generics/edit/{id}")
    public Generic editGenericById(@RequestBody Generic newGeneric, @PathVariable(value = "id") Long genericId) {
        return service.updateGeneric(newGeneric, genericId);
    }

    @DeleteMapping("/generics/delete/{id}")
    public void deleteGenericById(@PathVariable(value = "id") Long genericId){
        service.deleteGenericById(genericId);
    }
}
