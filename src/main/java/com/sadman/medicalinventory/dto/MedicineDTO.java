package com.sadman.medicalinventory.dto;

import lombok.*;

/**
 * @author Sadman
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {
    private Long brandId;
    private Long stockId;
    private double unitPrice;
    private double quantity;
    private double discount;
    private double total;
}
