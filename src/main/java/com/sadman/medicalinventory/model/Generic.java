package com.sadman.medicalinventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
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

    @ToString.Exclude
    @ManyToMany(mappedBy = "generics", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Indication> indications = new HashSet<>();
}
