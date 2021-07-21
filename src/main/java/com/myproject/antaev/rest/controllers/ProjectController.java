package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.data_type.StatusProject;
import com.myproject.antaev.rest.dto.CustomerResponseDto;
import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Tag(name = "Проекты", description = "Редактирование проектов")
public class ProjectController {

    @GetMapping
    @Operation(summary = "Список проектов")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        List<ProjectResponseDto> list = new ArrayList<>();
        list.add(new ProjectResponseDto(1, "First", new CustomerResponseDto(1, "Motya"), 1, StatusProject.CLOSED));
        list.add(new ProjectResponseDto(2, "Second", new CustomerResponseDto(2, "Vitya"), 2, StatusProject.OPEN));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание проекта")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        return ResponseEntity.ok()
                .body(new ProjectResponseDto(3, requestDto.getName_of_project(), requestDto.getCustomer(), 2,
                        requestDto.getStatus()));
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Изменение проекта")
    public ResponseEntity<ProjectResponseDto> updateProject(@RequestBody ProjectRequestDto requestDto,
                                                            @PathVariable Long id) {
        return ResponseEntity.ok()
                .body(new ProjectResponseDto(3, "Motya", new CustomerResponseDto(1, "Name1"), requestDto.getRelease_version(),
                        requestDto.getStatus()));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление проекта")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}