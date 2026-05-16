package com.shopee.ecom.mapper;

import com.shopee.ecom.dto.UserRequestDto;
import com.shopee.ecom.dto.UserResponseDto;
import com.shopee.ecom.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDto userRequestDto);

    UserResponseDto toResponse(User user);
}
