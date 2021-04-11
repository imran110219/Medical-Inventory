package com.sadman.medicalinventory.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sadman
 */
@Getter
@Setter
public class MedicineDTO {
    private Long brandId;
    private Long stockId;
    private double quantity;
    private double discount;
    private double total;
}
