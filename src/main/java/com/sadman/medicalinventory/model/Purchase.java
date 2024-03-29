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
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "purchase_invoice_id")
    private PurchaseInvoice purchaseInvoice;
    @Column(name = "batch_no")
    private String batchNo;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "box_id")
    private Box box;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "discount")
    private double discount;
    @Column(name = "total")
    private double total;
    @Column(name = "expiry_datetime")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date expiryDate;
    @Column(name = "datetime", insertable=false)
    private Date date;
}
