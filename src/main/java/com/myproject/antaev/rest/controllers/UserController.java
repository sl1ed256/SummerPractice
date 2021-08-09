package com.myproject.antaev.rest.controllers;


import com.myproject.antaev.rest.data_type.UserRights;
import com.myproject.antaev.rest.dto.UserRequestDto;
import com.myproject.antaev.rest.dto.UserResponseDto;

import com.myproject.antaev.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "Редактирование пользователей системы")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Список пользователей")
    public ResponseEntity<List<UserResponseDto>> getListUsers() {
        List<UserResponseDto> list = service.getListUsers();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @Operation(summary = "Создать пользователя")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = service.createUser(requestDto);
        return ResponseEntity.ok().body(userResponseDto);
    }

    @PutMapping(value = "/{userId}")
    @Operation(summary = "Изменить пользователя")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto requestDto,
                                                      @PathVariable int userId) {
        UserResponseDto userResponseDto = service.updateUser(requestDto, userId);
        return ResponseEntity.ok().body(userResponseDto);
    }

    @DeleteMapping(value = "/{userId}")
    @Operation(summary = "Удалить пользователя")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
