package com.ayush.product.productmanager.service;

import com.ayush.product.productmanager.entity.ProductEntity;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;

import java.util.List;

/**
 * Interface for Product CRUD
 *
 * @author Ayush
 */
public interface ProductService {

    /**
     * Given a Product Id Find the respective product Details
     * @param productId
     * @return
     */
    ProductEntity getProduct(long productId);

    /**
     * Create Products in the database, if it doesnot exist. If it exist, then this method will update it
     * @param products
     * @return
     */
    List<ProductVO> createProducts(List<ProductVO> products);

    /**
     * Given the list of ids of the product, Fetch the information for each of them.
     * NOTE: If Some product Id doesnot exist. The method will simply ignore it.
     * @param ids
     * @return
     */
    List<ProductVO> getProducts(List<ProductIdVo> ids);
}
