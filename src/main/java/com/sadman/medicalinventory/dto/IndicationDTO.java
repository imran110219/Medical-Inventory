package com.sadman.medicalinventory.dto;

import lombok.*;

import java.util.ArrayList;
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
public class IndicationDTO {
    private String name;
    private String description;
    private List<Long> genericIds = new ArrayList<>();
}
