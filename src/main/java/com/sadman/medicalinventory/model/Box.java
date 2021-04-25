package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Sadman
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="box")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "quantity")
    private double quantity;
}
