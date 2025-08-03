package com.harsh.ecommerce_backend.service;

import com.harsh.ecommerce_backend.dto.UserInputDTO;
import com.harsh.ecommerce_backend.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // Creates a user and returns the created UserDTO with generated fields (like id)
    UserResponseDTO createUser(UserInputDTO userInputDTO);

    // Retrieve a user by ID, Optional empty if not found
    UserResponseDTO getUserById(Long userId);

    // Retrieve user by email, Optional empty if not found
    Optional<UserResponseDTO> getUserByEmail(String email);

    // Update user details provided in the DTO; returns updated UserDTO
    UserResponseDTO updateUser(Long userId, UserInputDTO updatedUserInputDTO);

    // Delete user by ID, returns true if deletion was successful
    boolean deleteUser(Long userId);

    // (Optional) List all users or with some pagination/filtering
    List<UserResponseDTO> getAllUsers();
}
