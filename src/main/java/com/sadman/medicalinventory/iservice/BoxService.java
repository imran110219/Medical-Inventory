package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Box;

import java.util.List;

/**
 * @author Sadman
 */
public interface BoxService {
    List<Box> getAllBoxes();

    Box getBoxById(Long id) throws RecordNotFoundException;

    Box createBox(Box Box);

    Box updateBox(Box newBox, Long id);

    void deleteBoxById(Long id);

    boolean existsByName(String name);
}
