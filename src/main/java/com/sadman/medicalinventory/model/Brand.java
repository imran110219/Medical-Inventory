package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="strength")
    private String strength;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dosage_form_id")
    private DosageForm dosageForm;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "generic_id")
    private Generic generic;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "sale_price")
    private double salePrice;
}
