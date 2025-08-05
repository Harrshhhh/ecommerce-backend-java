package com.harsh.ecommerce_backend.dto;

import com.harsh.ecommerce_backend.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInputDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Positive
    private Double price;

    @Min(0)
    private int quantity;

    @NotNull
    private Category category;
}
