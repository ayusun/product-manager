package com.ayush.product.productmanager.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetProduct {

    private String id;

    private Date timestamp;

    private List<ProductIdVo> products;
}
