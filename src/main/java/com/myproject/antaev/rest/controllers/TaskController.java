package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.data_type.StatusProject;
import com.myproject.antaev.rest.data_type.StatusTask;
import com.myproject.antaev.rest.dto.*;
import com.myproject.antaev.service.TaskService;
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


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Задачи", description = "Редактирование задач")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Список задач")
    public ResponseEntity<List<TaskResponseDto>> readListTasks() {
        List<TaskResponseDto> list = service.readListAllTasks();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @Operation(summary = "Создание задачи")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        TaskResponseDto responseDto = service.createTask(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping(value = "/{taskId}")
    @Operation(summary = "Изменение задачи")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto requestDto,
                                                      @PathVariable int id) {
        TaskResponseDto responseDto = service.updateTask(requestDto, id);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping(value = "/{taskId}")
    @Operation(summary = "Удаление задачи")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return ResponseEntity.accepted().build();
    }


}
