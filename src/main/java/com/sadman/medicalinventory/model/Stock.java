package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "expired_datetime")
    private String expiredDate;
    @Column(name = "datetime", insertable=false)
    private String date;
}
