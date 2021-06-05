package com.sadman.medicalinventory.dto;

import com.sadman.medicalinventory.model.Generic;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndicationDTO {
    private String name;
    private String description;
    private List<Long> genericIds;
}
