package com.sadman.medicalinventory.model;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total")
    private double total;
    @Column(name = "vat")
    private double vat;
    @Column(name = "discount")
    private double discount;
    @Column(name = "payable")
    private double payable;
    @Column(name = "paid")
    private double paid;
    @Column(name = "returned")
    private double returned;
    @Column(name = "datetime", insertable=false)
    private String date;
}
