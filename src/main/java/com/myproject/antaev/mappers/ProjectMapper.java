package com.myproject.antaev.mappers;

import com.myproject.antaev.entity.CustomerEntity;
import com.myproject.antaev.entity.ProjectEntity;
import com.myproject.antaev.rest.dto.ProjectRequestDto;
import com.myproject.antaev.rest.dto.ProjectResponseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "customer", source = "customer.id")
    ProjectResponseDto entityToResponseDto(ProjectEntity projectEntity);

    List<ProjectResponseDto> listEntityToListResponseDto(List<ProjectEntity> listProjectEntity);

    @Mapping(target = "customer", ignore = true)
    ProjectEntity requestDtoToEntity(ProjectRequestDto projectRequestDto, @MappingTarget ProjectEntity projectEntity);

    @AfterMapping
    default void setNewCustomerWithId(ProjectRequestDto projectRequestDto,
                                      @MappingTarget ProjectEntity projectEntity) {
        CustomerEntity entity = new CustomerEntity();
        entity.setIdCustomer(projectRequestDto.getCustomer());
        projectEntity.setCustomer(entity);
    }
}
