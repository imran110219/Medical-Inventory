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
public class PurchaseReturnDTO {
    private Purchase purchase;
    private Stock stock;
    private Date expiryDate;
    private double quantity;
    private double costPrice;
    private double deduction;
    private double returnPrice;
    private boolean waste;
}
