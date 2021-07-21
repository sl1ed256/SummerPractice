package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.data_type.StatusProject;
import com.myproject.antaev.rest.data_type.StatusTask;
import com.myproject.antaev.rest.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .body(new TaskResponseDto(3, requestDto.getTask_number(), requestDto.getTask_name(),
                        new UserResponseDto(1, "Motya", new ArrayList<>()), new ProjectResponseDto(1,"s", new CustomerResponseDto(4,"Mat"),1, StatusProject.OPEN);
    }

    @PutMapping(value = "/{task_id}")
    @Operation(summary = "Изменение задачи")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto requestDto,
                                                      @PathVariable int task_id) {
        return ResponseEntity.ok()
                .body(new TaskResponseDto(task_id, requestDto.getTask_name(), requestDto.getTask_name(),
                        new UserResponseDto(1, "Motya",new ArrayList<>() ), new ProjectResponseDto()));
    }

    @DeleteMapping(value = "/{task_id}")
    @Operation(summary = "Удаление задачи")
    public ResponseEntity<?> deleteTask(@PathVariable int task_id) throws IOException {
        throw new FileNotFoundException();
    }

}
