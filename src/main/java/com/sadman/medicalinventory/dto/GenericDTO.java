package com.sadman.medicalinventory.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sadman.medicalinventory.model.Indication;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
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
public class GenericDTO {
    private String name;
    private String description;
    private List<Long> indicationIds = new ArrayList<>();
}
