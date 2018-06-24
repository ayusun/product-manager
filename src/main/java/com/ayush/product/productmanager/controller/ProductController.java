package com.ayush.product.productmanager.controller;

import com.ayush.product.productmanager.service.ProductService;
import com.ayush.product.productmanager.vo.GetProduct;
import com.ayush.product.productmanager.vo.ProductIdVo;
import com.ayush.product.productmanager.vo.ProductVO;
import com.ayush.product.productmanager.vo.PutProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @PutMapping(value = "/")
    public ResponseEntity createProduct(@RequestBody PutProductVo createProductEvent){
        List<ProductVO> products = createProductEvent.getProducts();
        try{
            List<ProductVO> dtos = productService.createProducts(products);
            return ResponseEntity.ok(dtos);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity getProducts(@RequestBody GetProduct getProductEvent){
        List<ProductIdVo> voIds = getProductEvent.getProducts();

        try{
            List<ProductVO> dtos = productService.getProducts(voIds);
            return ResponseEntity.ok(dtos);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

}
