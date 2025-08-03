package com.harsh.ecommerce_backend.service;

import com.harsh.ecommerce_backend.dto.UserInputDTO;
import com.harsh.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInputDTO createUser(UserInputDTO userInputDTO) {

        return null;
    }

    @Override
    public Optional<UserInputDTO> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserInputDTO> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserInputDTO updateUser(Long userId, UserInputDTO updatedUserInputDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }

    @Override
    public List<UserInputDTO> getAllUsers() {
        return List.of();
    }
}
