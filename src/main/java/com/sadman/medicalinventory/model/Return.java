package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="returned")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "deduction")
    private double deduction;
    @Column(name = "total")
    private double total;
    @Column(name = "wastage")
    private Boolean wastage;
    @Column(name = "datetime", insertable=false)
    private String date;
}
