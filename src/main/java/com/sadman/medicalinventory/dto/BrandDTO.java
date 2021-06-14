package com.sadman.medicalinventory.dto;

import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.model.Manufacturer;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Sadman
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private String name;
    private String strength;
    private Long dosageFormId;
    private Long genericId;
    private Long manufacturerId;
    private double purchasePrice;
    private double salePrice;
}
