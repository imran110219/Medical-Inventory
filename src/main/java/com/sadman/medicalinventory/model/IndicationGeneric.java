package com.sadman.medicalinventory.model;

import javax.persistence.*;

@Entity
@Table(name="indication_generic")
public class IndicationGeneric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "indication_id")
    private Indication indication;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "generic_id")
    private Generic generic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Indication getIndication() {
        return indication;
    }

    public void setIndication(Indication indication) {
        this.indication = indication;
    }

    public Generic getGeneric() {
        return generic;
    }

    public void setGeneric(Generic generic) {
        this.generic = generic;
    }

    @Override
    public String toString() {
        return "IndicationGeneric{" +
                "id=" + id +
                ", indication=" + indication +
                ", generic=" + generic +
                '}';
    }
}
