package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Sadman
 */
@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="dosage_form")
public class DosageForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    public DosageForm() {
    }

    public DosageForm(String name) {
        this.name = name;
    }
}
