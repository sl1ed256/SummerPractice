package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.dto.CustomerRequestDto;
import com.myproject.antaev.rest.dto.CustomerResponseDto;
import com.myproject.antaev.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Заказчики", description = "Редактирование заказчиков")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Список клиентов")
    public ResponseEntity<List<CustomerResponseDto>> getListCustomers() {
        List<CustomerResponseDto> list = new ArrayList<>();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание клиента")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto requestDto) {
        CustomerResponseDto customerResponseDto = service.createCustomer(requestDto);
        return ResponseEntity.ok(customerResponseDto);
    }

    @PutMapping(value = "/{idCustomer}")
    @Operation(summary = "Изменение данных клиента")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@RequestBody CustomerRequestDto requestDto, @PathVariable int idCustomer) {
        CustomerResponseDto customerResponseDto = service.updateCustomer(requestDto, idCustomer);
        return ResponseEntity.ok(customerResponseDto);
    }

    @DeleteMapping(value = "/{idCustomer}")
    @Operation(summary = "Удаление клиента")
    public ResponseEntity<?> deleteCustomer(@PathVariable int idCustomer) {
        service.deleteCustomer(idCustomer);
        return ResponseEntity.accepted().build();

    }
}
