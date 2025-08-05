package com.harsh.ecommerce_backend.service;

import com.harsh.ecommerce_backend.dto.ProductInputDTO;
import com.harsh.ecommerce_backend.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductInputDTO productInputDTO);

    ProductResponseDTO getProductById(Long productId);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(Long productId, ProductInputDTO productInputDTO);

    boolean deleteProduct(Long productId);

}
