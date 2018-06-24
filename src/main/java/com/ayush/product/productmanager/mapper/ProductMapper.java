package com.ayush.product.productmanager.mapper;

import com.ayush.product.productmanager.entity.ProductEntity;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductEntity convertProductVoToEntity(ProductVO vo){
        ProductEntity entity = new ProductEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setQuantity(vo.getQuantity());
        entity.setSaleAmount(vo.getSale_amount());
        return entity;
    }

    public static List<ProductEntity> convertproductVoListToEntityList(List<ProductVO> voList){
        List<ProductEntity> entities = voList.stream().map(vo -> convertProductVoToEntity(vo))
                .collect(Collectors.toList());
        return entities;
    }

    public static ProductVO convertProductEntityToProductVo(ProductEntity entity){
        ProductVO vo = new ProductVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setQuantity(entity.getQuantity());
        vo.setSale_amount(entity.getSaleAmount());
        return vo;
    }
    public static List<ProductVO> convertProductEntityListToProductVoList(List<ProductEntity> entities){
        List<ProductVO> dtos = entities.stream().map(entity->convertProductEntityToProductVo(entity))
                .collect(Collectors.toList());
        return dtos;
    }

    public static List<Long> convertProductIdVoListToIdList(List<ProductIdVo> vos){
        List<Long> ids = vos.stream().map(vo -> vo.getId()).collect(Collectors.toList());
        return ids;
    }
}
