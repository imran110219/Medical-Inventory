package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.ReturnService;
import com.sadman.medicalinventory.model.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReturnApiController {
    @Autowired
    ReturnService service;

    @GetMapping("/returns")
    public List<Return> getAllReturns(Model model) {
        return service.getAllReturns();
    }

    @GetMapping("/returns/{id}")
    public ResponseEntity<Return> getReturnById(@PathVariable(value = "id") Long returnId)
            throws RecordNotFoundException {
        Return returnObject = service.getReturnById(returnId);
        return ResponseEntity.ok().body(returnObject);
    }

    @PostMapping("/returns")
    public Return createReturn(@Valid @RequestBody Return returnObject) {
        return service.createReturn(returnObject);
    }

    @PutMapping("/returns/edit/{id}")
    public Return editReturnById(@RequestBody Return newReturn, @PathVariable(value = "id") Long returnId) {
        return service.updateReturn(newReturn, returnId);
    }

    @DeleteMapping("/returns/delete/{id}")
    public void deleteReturnById(@PathVariable(value = "id") Long returnId){
        service.deleteReturnById(returnId);
    }
}

