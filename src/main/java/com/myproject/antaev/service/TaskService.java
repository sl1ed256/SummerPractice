package com.myproject.antaev.service;

import com.myproject.antaev.rest.dto.TaskRequestDto;
import com.myproject.antaev.rest.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);

    TaskResponseDto readTask(int id);

    TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id);

    void deleteTask(int id);


    List<TaskResponseDto> readListAllTasks();
}
