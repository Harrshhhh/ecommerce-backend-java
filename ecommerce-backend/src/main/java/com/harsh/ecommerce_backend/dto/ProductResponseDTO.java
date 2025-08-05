package com.harsh.ecommerce_backend.dto;

import com.harsh.ecommerce_backend.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
