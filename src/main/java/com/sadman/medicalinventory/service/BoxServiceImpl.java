package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.BoxService;
import com.sadman.medicalinventory.model.Box;
import com.sadman.medicalinventory.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    BoxRepository repository;

    public List<Box> getAllBoxes() {
        return repository.findAll();
    }

    public Box getBoxById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Box createBox(Box Box){
        return repository.save(Box);
    }

    public Box updateBox(Box newBox, Long id) {
        return repository.findById(id)
                .map(Box -> {
                    Box.setName(newBox.getName());
                    Box.setQuantity(newBox.getQuantity());
                    return repository.save(Box);
                })
                .orElseGet(() -> {
                    newBox.setId(id);
                    return repository.save(newBox);
                });
    }

    public void deleteBoxById(Long id){
        repository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
