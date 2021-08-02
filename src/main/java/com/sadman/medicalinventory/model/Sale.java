package com.sadman.medicalinventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sale_invoice_id")
    private SaleInvoice saleInvoice;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "discount")
    private double discount;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "total")
    private double total;
    @Column(name = "datetime", insertable=false)
    private Date date;
}
