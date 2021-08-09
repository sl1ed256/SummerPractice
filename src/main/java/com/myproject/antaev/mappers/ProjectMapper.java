package com.myproject.antaev.mappers;


import com.myproject.antaev.entity.ProjectEntity;
import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "customer", source = "customer.id")
    ProjectResponseDto entityToResponseDto(ProjectEntity projectEntity);

    @Mapping(target = "customer", ignore = true)
    ProjectEntity requestDtoToEntity(ProjectRequestDto projectRequestDto, @MappingTarget ProjectEntity projectEntity);

}
