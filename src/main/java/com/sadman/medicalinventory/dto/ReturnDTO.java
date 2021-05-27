package com.sadman.medicalinventory.dto;

import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Stock;
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
public class ReturnDTO {
    private Long saleId;
    private Long purchaseId;
    private double quantity;
    private double unitPrice;
    private double deduction;
    private double returnPrice;
    private boolean waste;
}
