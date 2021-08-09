package com.myproject.antaev.service;

import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto createProject(ProjectRequestDto projectRequestDto);

    ProjectResponseDto readProject(int projectNumber);

    ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, int projectNumber);

    void deleteProject(int projectNumber);

}
