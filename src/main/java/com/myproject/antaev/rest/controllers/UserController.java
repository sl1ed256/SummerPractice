package com.myproject.antaev.rest.controllers;


import com.myproject.antaev.rest.data_type.Role;
import com.myproject.antaev.rest.dto.UserRequestDto;
import com.myproject.antaev.rest.dto.UserResponseDto;

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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "Редактирование пользователей системы")
public class UserController {

    @GetMapping
    @Operation(summary = "Список пользователей")
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> list = new ArrayList<>();
        list.add(new UserResponseDto(3, "Aaaa", new ArrayList<>()));
        list.add(new UserResponseDto(4, "Bbbb", new ArrayList<>()));
        list.add(new UserResponseDto(5, "Cccc", new ArrayList<>()));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @Operation(summary = "Создать пользователя")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ALL);
        return ResponseEntity.ok()
                .body(new UserResponseDto(3, requestDto.getName_user(), roles));
    }

    @PutMapping(value = "/{user_id}")
    @Operation(summary = "Измененить пользователя")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto requestDto,
                                                      @PathVariable int user_id) {
        List<Role> roles = new ArrayList<>();
        return ResponseEntity.ok()
                .body(new UserResponseDto(user_id, requestDto.getName_user(), roles));
    }

    @DeleteMapping(value = "/{user_id}")
    @Operation(summary = "Удалить пользователя")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
