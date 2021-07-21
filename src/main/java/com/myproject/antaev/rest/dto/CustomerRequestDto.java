package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Заказчик (запрос)")
public class CustomerRequestDto {

    @Schema(description = "ID заказчика")
    private int id_customer;


    @Schema(description = "Имя заказчика")
    private String name_customer;

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;

    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }
}
