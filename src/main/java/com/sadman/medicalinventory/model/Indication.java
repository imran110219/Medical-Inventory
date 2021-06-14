package com.sadman.medicalinventory.model;

import com.fasterxml.jackson.annotation.*;
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
@Table(name="indication")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Indication.class)
public class Indication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "indication_generic", joinColumns = {@JoinColumn(name = "indication_id")}, inverseJoinColumns = {@JoinColumn(name = "generic_id")})
//    @JsonManagedReference
//    @JsonIdentityReference
    private Set<Generic> generics = new HashSet<>();
}
