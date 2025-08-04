package com.harsh.ecommerce_backend.service;

import com.harsh.ecommerce_backend.dto.UserInputDTO;
import com.harsh.ecommerce_backend.dto.UserResponseDTO;
import com.harsh.ecommerce_backend.entity.User;
import com.harsh.ecommerce_backend.exceptions.ResourceNotFoundException;
import com.harsh.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserInputDTO userInputDTO) {
        User user = userDtoToUser(userInputDTO);
        User savedUser = userRepository.save(user);
        return convertToUserResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->  new ResourceNotFoundException("User not found with id: "+ userId));
        return convertToUserResponseDTO(user);
    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(this::convertToUserResponseDTO);
    }

    @Override
    public UserResponseDTO updateUser(Long userId, UserInputDTO updatedUserInputDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ userId));
        user.setName(updatedUserInputDTO.getName());
        user.setEmail(updatedUserInputDTO.getEmail());
        user.setPassword(updatedUserInputDTO.getPassword());
        user.setRole(updatedUserInputDTO.getRole());

        User updatedUser = userRepository.save(user);
        return convertToUserResponseDTO(updatedUser);
    }

    @Override
    public boolean deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ userId));
        userRepository.delete(user);
        return true;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users =userRepository.findAll();

        return users.stream().map(this::convertToUserResponseDTO).collect(Collectors.toList());
    }

    //Conversion from UserInputDTo to User
    private User userDtoToUser(UserInputDTO userInputDTO){
        User user = new User();
        user.setName(userInputDTO.getName());
        user.setEmail(userInputDTO.getEmail());
        user.setPassword(userInputDTO.getPassword());
        user.setRole(userInputDTO.getRole());
        return user;
    }

    //Conversion from User to UserResponseDTO
    private UserResponseDTO convertToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setModifiedAt(user.getUpdatedAt());
        return userResponseDTO;
    }
}
