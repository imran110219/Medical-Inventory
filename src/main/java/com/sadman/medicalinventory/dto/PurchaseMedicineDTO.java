package com.sadman.medicalinventory.dto;

import lombok.*;

import java.util.Date;

/**
 * @author Sadman
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseMedicineDTO {
    private Long brandId;
    private String batchNo;
    private Long boxId;
    private Long stockId;
    private double unitPrice;
    private double quantity;
    private double discount;
    private double total;
    private Date expiryDate;
}
