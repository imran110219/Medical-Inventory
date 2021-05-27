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
public class ReturnListDTO {
    private List<ReturnDTO> returnDTOList;
}
