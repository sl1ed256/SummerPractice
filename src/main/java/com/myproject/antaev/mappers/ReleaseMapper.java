package com.myproject.antaev.mappers;


import com.myproject.antaev.entity.ReleaseEntity;
import com.myproject.antaev.rest.dto.ReleaseRequestDto;
import com.myproject.antaev.rest.dto.ReleaseResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ReleaseMapper {
    @Mapping(target = "project", source = "project.id")
    ReleaseResponseDto entityToResponseDto(ReleaseEntity releaseEntity);

    List<ReleaseResponseDto> listEntityToListResponseDto(List<ReleaseEntity> entityList);

    @Mapping(target = "project", source = "project", qualifiedByName = "newProject")
    ReleaseEntity requestDtoToEntity(ReleaseRequestDto requestDto, @MappingTarget ReleaseEntity entity);

}
