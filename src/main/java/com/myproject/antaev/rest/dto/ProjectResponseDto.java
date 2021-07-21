package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusProject;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект (ответ)")
public class ProjectResponseDto {
    @Schema(description = "ID проекта")
    private int project_number;
    @Schema(description = "Наименование проекта")
    private String name_of_project;
    @Schema(description = "Заказчик")
    private CustomerResponseDto customer;
    @Schema(description = "Версия релиза")
    private int release_version;
    @Schema(description = "Статус проекта")
    private StatusProject status;

    public ProjectResponseDto(int project_number, String name_of_project, CustomerResponseDto customer, Integer release_version, StatusProject status) {
        this.project_number = project_number;
        this.name_of_project = name_of_project;
        this.customer = customer;
        this.release_version = release_version;
        this.status = status;
    }

    public int getProject_number() {
        return project_number;
    }

    public String getName_of_project() {
        return name_of_project;
    }

    public CustomerResponseDto getCustomer() {
        return customer;
    }

    public Integer getRelease_version() {
        return release_version;
    }

    public StatusProject getStatus() {
        return status;
    }

}
