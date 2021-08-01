package com.myproject.antaev.service.impl;

import com.myproject.antaev.entity.TaskEntity;
import com.myproject.antaev.mappers.TaskMapper;
import com.myproject.antaev.repository.TaskRepository;
import com.myproject.antaev.rest.controllers.exceptions.NotFoundException;
import com.myproject.antaev.rest.dto.TaskRequestDto;
import com.myproject.antaev.rest.dto.TaskResponseDto;
import com.myproject.antaev.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskMapper mapper;
    private final TaskRepository repository;

    public TaskServiceImpl(TaskMapper mapper, TaskRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        TaskEntity taskEntity = mapper.requestDtoToEntity(taskRequestDto, new TaskEntity());
        taskEntity = repository.save(taskEntity);
        return mapper.entityToResponseDto(taskEntity);
    }

    @Override
    public TaskResponseDto readTask(int id) {
        TaskEntity taskEntity = getOrElseThrow(id);
        return mapper.entityToResponseDto(taskEntity);
    }

    @Override
    @Transactional
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id) {
        TaskEntity taskEntity = getOrElseThrow(id);
        taskEntity = mapper.requestDtoToEntity(taskRequestDto, taskEntity);
        return mapper.entityToResponseDto(taskEntity);
    }

    @Override
    public void deleteTask(int id) {
        getOrElseThrow(id);
        repository.deleteById(id);
    }

    private TaskEntity getOrElseThrow(int id) {
        Optional<TaskEntity> TaskEntity = repository.findById(id);
        return TaskEntity.orElseThrow(() -> new NotFoundException(String.format("Задачи с таким id не существует")));
    }


    @Override
    public List<TaskResponseDto> readListAllTasks() {
        List<TaskEntity> list = repository.findAll();
        return mapper.listEntityToListResponseDto(list);
    }
}
