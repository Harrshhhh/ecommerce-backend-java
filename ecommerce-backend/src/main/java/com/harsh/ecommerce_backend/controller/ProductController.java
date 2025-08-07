package com.harsh.ecommerce_backend.controller;

import com.harsh.ecommerce_backend.dto.ProductInputDTO;
import com.harsh.ecommerce_backend.dto.ProductResponseDTO;
import com.harsh.ecommerce_backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductInputDTO productInputDTO){
        ProductResponseDTO createdProduct = productService.createProduct(productInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") Long productId){
        ProductResponseDTO productById = productService.getProductById(productId);
        return ResponseEntity.ok(productById);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") Long productId, @Valid @RequestBody ProductInputDTO productInputDTO){
        ProductResponseDTO productResponseDTO =  productService.updateProduct(productId, productInputDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ("id") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}