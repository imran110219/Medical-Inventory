package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="generic")
public class Generic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "generics", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Indication> indications = new HashSet<>();
}
