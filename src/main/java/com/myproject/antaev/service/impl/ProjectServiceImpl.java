package com.myproject.antaev.service.impl;

import com.myproject.antaev.entity.ProjectEntity;
import com.myproject.antaev.mappers.ProjectMapper;
import com.myproject.antaev.repository.ProjectRepository;
import com.myproject.antaev.rest.controllers.exceptions.NotFoundException;
import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;
import com.myproject.antaev.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper mapper;
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectMapper mapper, ProjectRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto) {
        ProjectEntity projectEntity = mapper.requestDtoToEntity(projectRequestDto, new ProjectEntity());
        projectEntity = repository.save(projectEntity);
        return mapper.entityToResponseDto(projectEntity);
    }

    @Override
    public ProjectResponseDto readProject(int projectNumber) {
        ProjectEntity projectEntity = getOrElseThrow(projectNumber);
        return mapper.entityToResponseDto(projectEntity);
    }

    @Override
    @Transactional
    public ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, int projectNumber) {
        ProjectEntity projectEntity = getOrElseThrow(projectNumber);
        projectEntity = mapper.requestDtoToEntity(projectRequestDto, projectEntity);
        return mapper.entityToResponseDto(projectEntity);
    }

    @Override
    public void deleteProject(int projectNumber) {
        getOrElseThrow(projectNumber);
        repository.deleteById(projectNumber);
    }

    private ProjectEntity getOrElseThrow(int projectNumber) {
        Optional<ProjectEntity> projectEntity = repository.findById(projectNumber);
        return projectEntity.orElseThrow(() -> new NotFoundException(String.format("Такого заказчика не существует")));
    }
}
