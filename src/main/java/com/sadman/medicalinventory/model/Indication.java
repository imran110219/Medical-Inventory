package com.sadman.medicalinventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="indication")
public class Indication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "indication_generic",
            joinColumns = {@JoinColumn(name = "indication_id")},
            inverseJoinColumns = {@JoinColumn(name = "generic_id")}
    )
    private Set<Generic> generics = new HashSet<>();
}
