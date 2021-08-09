package com.myproject.antaev.service;

import com.myproject.antaev.rest.dto.CustomerRequestDto;
import com.myproject.antaev.rest.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    CustomerResponseDto readCustomer(int idCustomer);
    CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto, int idCustomer);
    void deleteCustomer(int idCustomer);
    List<CustomerResponseDto> getListCustomers();
}
