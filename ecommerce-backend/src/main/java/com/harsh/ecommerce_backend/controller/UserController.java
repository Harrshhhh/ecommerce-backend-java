package com.harsh.ecommerce_backend.controller;

import com.harsh.ecommerce_backend.dto.UserInputDTO;
import com.harsh.ecommerce_backend.dto.UserResponseDTO;
import com.harsh.ecommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserInputDTO userInputDTO){
        UserResponseDTO createdUser = userService.createUser(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long userId){
        UserResponseDTO userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long userId, @Valid @RequestBody UserInputDTO userInputDTO){
        UserResponseDTO userResponseDTO = userService.updateUser(userId, userInputDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
