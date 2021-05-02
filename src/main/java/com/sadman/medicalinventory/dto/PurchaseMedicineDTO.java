package com.sadman.medicalinventory.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PurchaseMedicineDTO {
    private Long brandId;
    private String batchNo;
    private Long boxId;
    private Long locationId;
    private double unitPrice;
    private double quantity;
    private double discount;
    private double total;
    private Date expiryDate;
}
