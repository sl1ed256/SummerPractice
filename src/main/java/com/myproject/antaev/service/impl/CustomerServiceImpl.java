package com.myproject.antaev.service.impl;

import com.myproject.antaev.entity.CustomerEntity;
import com.myproject.antaev.mappers.CustomerMapper;
import com.myproject.antaev.repository.CustomerRepository;
import com.myproject.antaev.rest.controllers.exceptions.NotFoundException;
import com.myproject.antaev.rest.dto.CustomerRequestDto;
import com.myproject.antaev.rest.dto.CustomerResponseDto;

import com.myproject.antaev.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.repository = customerRepository;
        this.mapper = customerMapper;
    }

    @Override
    public CustomerResponseDto readCustomer(int idCustomer) {
        CustomerEntity customerEntity = getOrElseThrow(idCustomer);
        return mapper.entityToResponse(customerEntity);
    }

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        CustomerEntity customerEntity = mapper.requestToEntity(customerRequestDto, new CustomerEntity());
        customerEntity = repository.save(customerEntity);
        return mapper.entityToResponse(customerEntity);
    }

    @Override
    @Transactional
    public CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto, int idCustomer) {
        CustomerEntity customerEntity = getOrElseThrow(idCustomer);
        customerEntity = mapper.requestToEntity(customerRequestDto, customerEntity);
        return mapper.entityToResponse(customerEntity);
    }

    @Override
    public void deleteCustomer(int idCustomer) {
        CustomerEntity customerEntity = getOrElseThrow(idCustomer);
        repository.deleteById(idCustomer);
    }

    @Override
    public List<CustomerResponseDto> getListCustomers() {
        List<CustomerEntity> list = repository.findAll();
        return mapper.entitiesToResponses(list);
    }

    private CustomerEntity getOrElseThrow(int idCustomer) {
        Optional<CustomerEntity> optionalCustomer = repository.findById(idCustomer);
        return optionalCustomer.orElseThrow(() -> new NotFoundException(String.format("Такого заказчика не существует")));
    }
}
