package com.ayush.product.productmanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private int quantity;

    @Column(name="sale_amount")
    private BigDecimal saleAmount;
}
