package com.sadman.medicalinventory.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.util.List;

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
public class PurchaseInvoiceDTO {
    private Long supplierId;
    private Long manufacturerId;
    private List<PurchaseMedicineDTO> purchaseMedicineDTOList;
    private double averageDiscount;
    private double totalDiscount;
    private double grandTotal;
    private double paidAmount;
    private double changeAmount;
}
