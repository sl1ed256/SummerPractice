package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.dto.CustomerRequestDto;
import com.myproject.antaev.rest.dto.CustomerResponseDto;
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

    @GetMapping
    @Operation(summary = "Список клиентов")
    public ResponseEntity<List<CustomerResponseDto>> getCustomers() {
        List<CustomerResponseDto> list = new ArrayList<>();
        list.add(new CustomerResponseDto(1, "Name1"));
        list.add(new CustomerResponseDto(2, "Name2"));
        list.add(new CustomerResponseDto(3, "Name3"));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание клиента")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto requestDto) {
        return ResponseEntity.ok()
                .body(new CustomerResponseDto(1, requestDto.getNameCustomer()));
    }

    @PutMapping(value = "/{idCustomer}")
    @Operation(summary = "Изменение данных клиента")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@RequestBody CustomerRequestDto requestDto,
                                                              @PathVariable int idCustomer) {
        return ResponseEntity.ok()
                .body(new CustomerResponseDto(idCustomer, requestDto.getNameCustomer()));
    }

    @DeleteMapping(value = "/{idCustomer}")
    @Operation(summary = "Удаление клиента")
    public ResponseEntity<?> deleteCustomer(@PathVariable int idCustomer) {
        return ResponseEntity.ok().build();
    }
}
