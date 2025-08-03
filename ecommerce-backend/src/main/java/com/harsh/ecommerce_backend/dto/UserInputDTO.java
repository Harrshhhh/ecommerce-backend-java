package com.harsh.ecommerce_backend.dto;

import com.harsh.ecommerce_backend.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInputDTO {
    @NotBlank
    @Size(max = 100)
    private String name;

    @Email(message = "Invalid format")
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotNull(message = "Role is required")
    private Role role;

}
