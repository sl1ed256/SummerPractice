package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.data_type.StatusProject;
import com.myproject.antaev.rest.data_type.StatusTask;
import com.myproject.antaev.rest.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Задачи", description = "Редактирование задач")
public class TaskController {

    @GetMapping
    @Operation(summary = "Список задач")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> list = new ArrayList<>();
        UserResponseDto userResponseDto = new UserResponseDto(1, "Matvey", new ArrayList<>());
        ProjectResponseDto projectResponseDto = new ProjectResponseDto(1,"s", new CustomerResponseDto(2,"Mat"),1, StatusProject.OPEN);
        list.add(new TaskResponseDto(1, 2, 3, userResponseDto, "First", StatusTask.DONE));
        list.add(new TaskResponseDto(1, 3, 4, userResponseDto, "Second", StatusTask.IN_PROGRESS));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @Operation(summary = "Создание задачи")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.ok()
                .body(new TaskResponseDto(3, requestDto.getTaskNumber(), requestDto.getTaskName(),
                        new UserResponseDto(1, "Motya", new ArrayList<>()), new ProjectResponseDto()));
    }

    @PutMapping(value = "/{taskId}")
    @Operation(summary = "Изменение задачи")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto requestDto,
                                                      @PathVariable int taskId) {
        return ResponseEntity.ok()
                .body(new TaskResponseDto(taskId, requestDto.getTaskName(), requestDto.getTaskName(),
                        new UserResponseDto(1, "Motya",new ArrayList<>() ), new ProjectResponseDto()));
    }

    @DeleteMapping(value = "/{taskId}")
    @Operation(summary = "Удаление задачи")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId) throws IOException {
        throw new FileNotFoundException();
    }

}
