package com.myproject.antaev.mappers;

import com.myproject.antaev.entity.CustomerEntity;
import com.myproject.antaev.rest.dto.CustomerRequestDto;
import com.myproject.antaev.rest.dto.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto entityToResponse(CustomerEntity customerEntity);

    List<CustomerResponseDto> entitiesToResponses(List<CustomerEntity> customerEntities);

    CustomerEntity requestToEntity(CustomerRequestDto customerRequestDto, @MappingTarget CustomerEntity customerEntity);
}
