package com.ayush.product.productmanager.service;

import com.ayush.product.productmanager.entity.ProductEntity;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;

import java.util.List;

public interface ProductService {

    ProductEntity getProduct(long productId);

    List<ProductVO> createProducts(List<ProductVO> products);

    List<ProductVO> getProducts(List<ProductIdVo> ids);
}
