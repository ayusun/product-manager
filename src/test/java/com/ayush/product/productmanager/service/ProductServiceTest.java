package com.ayush.product.productmanager.service;

import com.ayush.product.productmanager.entity.ProductEntity;
import com.ayush.product.productmanager.repository.ProductDao;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductServiceImpl productService;

    List<ProductVO> products;
    ProductVO vo1;
    ProductVO vo2;

    ProductEntity entity1;
    ProductEntity entity2;
    List<ProductEntity> entities;

    ProductIdVo voId1;
    ProductIdVo voId2;

    private void setupProducts() {
        vo1 = new ProductVO();
        vo1.setId(1);
        vo1.setName("Test1");
        vo1.setQuantity(1);
        vo1.setSale_amount(new BigDecimal(500));

        vo2 = new ProductVO();
        vo2.setId(2);
        vo2.setName("Test2");
        vo2.setQuantity(5);
        vo2.setSale_amount(new BigDecimal(200));

        entity1 = new ProductEntity();
        entity1.setId(1);
        entity1.setName("Test1");
        entity1.setQuantity(1);
        entity1.setSaleAmount(new BigDecimal(500));

        entity2 = new ProductEntity();
        entity2.setId(2);
        entity2.setName("Test2");
        entity2.setQuantity(5);
        entity2.setSaleAmount(new BigDecimal(200));

        voId1 = new ProductIdVo();
        voId1.setId(1);
        voId2 = new ProductIdVo();
        voId2.setId(2);

    }

    @Before
    public void setup() {
        setupProducts();
        products = Arrays.asList(vo1, vo2);
        entities = Arrays.asList(entity1, entity2);
    }

    @Test
    public void testCreateProduct() {
        when(productDao.saveAll(anyList())).thenReturn(entities);
        List<ProductVO> insertedProducts = productService.createProducts(products);
        verify(productDao, times(1)).saveAll(anyList());
        assertEquals(insertedProducts, products);
    }

    @Test
    public void testGetProducts(){
        List<Long> idList = Arrays.asList(1L, 2L);
        when(productDao.findAllById(idList)).thenReturn(entities);
        List<ProductVO> foundProducts = productService.getProducts(Arrays.asList(voId1, voId2));
        verify(productDao, times(1)).findAllById(anyList());
        assertEquals(foundProducts, products);

    }

}
