package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Заказчик (ответ)")
public class CustomerResponseDto {

    @Schema(description = "ID заказчика")
    private int idCustomer;
    @Schema(description = "Имя заказчика")
    private String nameCustomer;


    public int getIdCustomer() {
        return idCustomer;
    }

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
