package com.sadman.medicalinventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
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

    public Generic() {
    }

    public Generic(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Generic(String name, String description, Set<Indication> indications) {
        this.name = name;
        this.description = description;
        this.indications = indications;
    }
}
