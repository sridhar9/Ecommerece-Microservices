package com.microservices.ecommerce.productservice.controller;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedProduct);
    }

    @PostMapping("/addproducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        List<Product> savedProducts = productService.addProducts(products);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedProducts);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> findProductById(@PathVariable("product_id") String productId) throws Exception {
        Product product = productService.findProductById(productId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);
    }


}









