package com.sadman.medicalinventory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    private Date date;
}
