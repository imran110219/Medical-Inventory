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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "brand_location", joinColumns = @JoinColumn(name = "brand_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "generic_id")
    private Generic generic;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "price")
    private double price;
}
