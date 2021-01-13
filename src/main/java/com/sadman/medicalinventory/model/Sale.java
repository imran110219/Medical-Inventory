package com.sadman.medicalinventory.model;

import javax.persistence.*;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private double quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "total")
    private double total;
    @Column(name = "datetime", insertable=false)
    private String date;
}
