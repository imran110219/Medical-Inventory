package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @Column(name = "batch_no")
    private String batchNo;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "total")
    private double total;
    @Column(name = "expiry_datetime")
    private String expiryDate;
    @Column(name = "datetime", insertable=false)
    private String date;
}
