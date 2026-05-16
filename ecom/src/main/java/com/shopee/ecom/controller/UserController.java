package com.shopee.ecom.controller;


import com.shopee.ecom.dto.LoginRequest;
import com.shopee.ecom.dto.UserRequestDto;
import com.shopee.ecom.dto.UserResponseDto;
import com.shopee.ecom.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(
            @Valid @RequestBody UserRequestDto user) {

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @RequestBody LoginRequest request) {

        UserResponseDto response = userService.login(
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(response);
    }


}