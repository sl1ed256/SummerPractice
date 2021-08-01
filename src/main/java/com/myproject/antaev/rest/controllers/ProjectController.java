package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.data_type.StatusProject;
import com.myproject.antaev.rest.dto.CustomerResponseDto;
import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;

import com.myproject.antaev.service.ProjectService;
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


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Tag(name = "Проекты", description = "Редактирование проектов")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Список проектов")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        List<ProjectResponseDto> list = new ArrayList<>();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание проекта")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        return ResponseEntity.ok().body(service.createProject(requestDto));
    }

    @PutMapping(value = "/{idProject}")
    @Operation(summary = "Изменение проекта")
    public ResponseEntity<ProjectResponseDto> updateProject(@RequestBody ProjectRequestDto requestDto,
                                                            @PathVariable int idProject) {
        return ResponseEntity.ok().body(service.updateProject(requestDto, idProject));
    }

    @DeleteMapping(value = "/{idProject}")
    @Operation(summary = "Удаление проекта")
    public ResponseEntity<?> deleteProject(@PathVariable int idProject) {
        service.deleteProject(idProject);
        return ResponseEntity.accepted().build();
    }
}