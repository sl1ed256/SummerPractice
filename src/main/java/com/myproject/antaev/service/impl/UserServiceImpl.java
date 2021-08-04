package com.myproject.antaev.service.impl;

import com.myproject.antaev.entity.UserEntity;
import com.myproject.antaev.mappers.UserMapper;
import com.myproject.antaev.repository.UserRepository;
import com.myproject.antaev.rest.controllers.exceptions.NotFoundException;
import com.myproject.antaev.rest.dto.UserRequestDto;
import com.myproject.antaev.rest.dto.UserResponseDto;
import com.myproject.antaev.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.repository = userRepository;
        this.mapper = userMapper;
    }

    @Override
    public UserResponseDto readUser(int userId) {
        UserEntity userEntity = getOrElseThrow(userId);
        return mapper.entityToResponse(userEntity);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = mapper.requestToEntity(userRequestDto, new UserEntity());
        userEntity = repository.save(userEntity);
        return mapper.entityToResponse(userEntity);
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(UserRequestDto userRequestDto, int userId) {
        UserEntity userEntity = getOrElseThrow(userId);
        userEntity = mapper.requestToEntity(userRequestDto, userEntity);
        return mapper.entityToResponse(userEntity);
    }

    @Override
    public void deleteUser(int userId) {
        UserEntity userEntity = getOrElseThrow(userId);
        repository.deleteById(userId);
    }

    @Override
    public List<UserResponseDto> getListUsers() {
        List<UserEntity> list = repository.findAll();
        return mapper.entitiesToResponsesDto(list);
    }

    private UserEntity getOrElseThrow(int userId) {
        Optional<UserEntity> userOptional = repository.findById(userId);
        return userOptional.orElseThrow(() -> new NotFoundException(String.format("Пользователь с номером = %d не найден", userId)));
    }
}
