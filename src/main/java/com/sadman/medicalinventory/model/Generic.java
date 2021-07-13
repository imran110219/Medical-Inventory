package com.sadman.medicalinventory.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="generic")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Generic.class)
public class Generic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "generics", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonBackReference
//    @JsonIdentityReference
    private Set<Indication> indications = new HashSet<>();

    public Generic() {
    }

    public Generic(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
