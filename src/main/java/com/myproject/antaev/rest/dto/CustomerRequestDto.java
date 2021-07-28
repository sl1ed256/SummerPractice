package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Заказчик (запрос)")
public class CustomerRequestDto {

    @Schema(description = "ID заказчика")
    private int idCustomer;


    @Schema(description = "Имя заказчика")
    private String nameCustomer;

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;

    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
}
