package com.shopee.ecom.service;

import com.shopee.ecom.dto.UserRequestDto;
import com.shopee.ecom.dto.UserResponseDto;
import com.shopee.ecom.entity.User;
import com.shopee.ecom.mapper.UserMapper;
import com.shopee.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponseDto register(UserRequestDto userRequest) {

        User user = userMapper.toEntity(userRequest);
        User save = userRepository.save(user);
        UserResponseDto response = userMapper.toResponse(user);
        return response;
    }

    public UserResponseDto login(String email, String password) {
        User user = userRepository
                .findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }
        UserResponseDto response = userMapper.toResponse(user);
        return response;

    }

}
