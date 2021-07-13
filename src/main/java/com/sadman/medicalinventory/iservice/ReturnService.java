package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.ReturnListDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Return;
import com.sadman.medicalinventory.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
public interface ReturnService {
    List<Return> getAllReturns();

    Return getReturnById(Long id) throws RecordNotFoundException;

    Return createReturn(Return returnObject);

    Return updateReturn(Return newReturn, Long id);

    void deleteReturnById(Long id);

    void returnProcess(ReturnListDTO returnListDTO);
}
