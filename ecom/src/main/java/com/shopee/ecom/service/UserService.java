package com.shopee.ecom.service;

import com.shopee.ecom.dto.UserRequestDto;
import com.shopee.ecom.dto.UserResponseDto;
import com.shopee.ecom.entity.User;
import com.shopee.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto register(UserRequestDto userRequest) {

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setRole(userRequest.getRole());

        User save = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(save.getId());
        userResponseDto.setName(save.getName());
        userResponseDto.setEmail(save.getEmail());
        userResponseDto.setPhone(save.getPhone());
        userResponseDto.setRole(save.getRole());
        return userResponseDto;
    }

    public UserResponseDto login(String email, String password) {

        User user = userRepository
                .findByEmailAndPassword(email, password);

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setRole(user.getRole());

        return userResponseDto;

    }

}
