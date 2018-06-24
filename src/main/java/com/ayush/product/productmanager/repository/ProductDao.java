package com.ayush.product.productmanager.repository;

import com.ayush.product.productmanager.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {
}
