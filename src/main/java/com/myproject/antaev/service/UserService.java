package com.myproject.antaev.service;

import com.myproject.antaev.rest.dto.UserRequestDto;
import com.myproject.antaev.rest.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto readUser(int userId);
    UserResponseDto updateUser(UserRequestDto userRequestDto, int userId);
    void deleteUser(int userId);
    List<UserResponseDto> getListUsers();
}
