package com.myproject.antaev.mappers;

import com.myproject.antaev.entity.UserEntity;
import com.myproject.antaev.rest.dto.UserRequestDto;
import com.myproject.antaev.rest.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto entityToResponse(UserEntity userEntity);

    List<UserResponseDto> entitiesToResponsesDto(List<UserEntity> userEntities);

    UserEntity requestToEntity(UserRequestDto userRequestDto, @MappingTarget UserEntity userEntity);
}
