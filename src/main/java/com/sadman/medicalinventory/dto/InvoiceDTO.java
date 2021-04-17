package com.sadman.medicalinventory.dto;

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
public class InvoiceDTO {
    private String customerName;
    private String mobileNumber;
    private List<MedicineDTO> medicineDTOList;
    private double averageDiscount;
    private double totalDiscount;
    private double grandTotal;
}
