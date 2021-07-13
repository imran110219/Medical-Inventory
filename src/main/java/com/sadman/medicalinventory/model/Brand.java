package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
//@ToString
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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dosage_form_id")
    private DosageForm dosageForm;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "generic_id")
    private Generic generic;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "sale_price")
    private double salePrice;

    public Brand(String name, String strength, DosageForm dosageForm, Generic generic, Manufacturer manufacturer, double purchasePrice, double salePrice) {
        this.name = name;
        this.strength = strength;
        this.dosageForm = dosageForm;
        this.generic = generic;
        this.manufacturer = manufacturer;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }
}
