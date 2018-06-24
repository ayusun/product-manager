package com.ayush.product.productmanager.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVO {

    private long id;
    private String name;
    private int quantity;
    private BigDecimal sale_amount;
}
