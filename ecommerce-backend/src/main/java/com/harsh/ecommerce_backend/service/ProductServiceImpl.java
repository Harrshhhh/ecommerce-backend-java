package com.harsh.ecommerce_backend.service;

import com.harsh.ecommerce_backend.dto.ProductInputDTO;
import com.harsh.ecommerce_backend.dto.ProductResponseDTO;
import com.harsh.ecommerce_backend.entity.Product;
import com.harsh.ecommerce_backend.exceptions.ResourceNotFoundException;
import com.harsh.ecommerce_backend.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductResponseDTO createProduct(ProductInputDTO productInputDTO) {
        Product product = convertToProduct(productInputDTO);
        Product savedProduct = productRepository.save(product);
        return convertToProductResponseDTO(savedProduct);

    }

    @Override
    public ProductResponseDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found by id: " + productId));
        return convertToProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToProductResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO updateProduct(Long productId, ProductInputDTO updateProductInputDTO) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found by id: " + productId));
        product.setName(updateProductInputDTO.getName());
        product.setCategory(updateProductInputDTO.getCategory());
        product.setPrice(updateProductInputDTO.getPrice());
        product.setDescription(updateProductInputDTO.getDescription());
        product.setQuantity(updateProductInputDTO.getQuantity());

        Product updatedProduct = productRepository.save(product);
        return convertToProductResponseDTO(updatedProduct);
    }

    @Override
    public boolean deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found by id: " + productId));
        productRepository.delete(product);
        return true;
    }

    private Product convertToProduct(ProductInputDTO productInputDTO) {
        return this.modelMapper.map(productInputDTO, Product.class);
    }

    private ProductResponseDTO convertToProductResponseDTO(Product product) {
        return this.modelMapper.map(product, ProductResponseDTO.class);

    }
}
