package com.myproject.antaev.mappers;


import com.myproject.antaev.entity.TaskEntity;

import com.myproject.antaev.rest.dto.TaskRequestDto;
import com.myproject.antaev.rest.dto.TaskResponseDto;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;


import java.util.List;

public interface TaskMapper {
    @Mappings({
            @Mapping(target = "author", expression = "java(taskEntity.getAuthor().getTaskNumber())"),

    })
    TaskResponseDto entityToResponseDto(TaskEntity taskEntity);

    List<TaskResponseDto> listEntityToListResponseDto(List<TaskEntity> entityList);

    @Mappings({
            @Mapping(target = "author", source = "author", qualifiedByName = "getNewUserWithId"),
    })
    TaskEntity requestDtoToEntity(TaskRequestDto requestDto, @MappingTarget TaskEntity entity);


}
