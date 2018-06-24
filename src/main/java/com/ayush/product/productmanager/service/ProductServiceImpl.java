package com.ayush.product.productmanager.service;

import com.ayush.product.productmanager.entity.ProductEntity;
import com.ayush.product.productmanager.mapper.ProductMapper;
import com.ayush.product.productmanager.repository.ProductDao;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements  ProductService {

    private final ProductDao productDao;

    @Override
    public ProductEntity getProduct(long productId) {

        ProductEntity entity = productDao.findById(productId).orElse(null);
        return entity;
    }

    @Override
    public List<ProductVO> createProducts(List<ProductVO> products) {
        List<ProductEntity> convertedEntities = ProductMapper.convertproductVoListToEntityList(products);
        List<ProductEntity> entities = productDao.saveAll(convertedEntities);
        List<ProductVO> dtos = ProductMapper.convertProductEntityListToProductVoList(entities);

        return dtos;
    }

    @Override
    public List<ProductVO> getProducts(List<ProductIdVo> voIds) {
        List<Long> ids = ProductMapper.convertProductIdVoListToIdList(voIds);
        List<ProductEntity> entities = productDao.findAllById(ids);
        List<ProductVO> dtos = ProductMapper.convertProductEntityListToProductVoList(entities);
        return dtos;
    }
}
