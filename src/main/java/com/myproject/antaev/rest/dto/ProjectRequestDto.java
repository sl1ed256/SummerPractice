package com.myproject.antaev.rest.dto;


import com.myproject.antaev.rest.data_type.StatusProject;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект (запрос)")
public class ProjectRequestDto {
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

    public int getProject_number() {
        return project_number;
    }

    public void setProject_number(int project_number) {
        this.project_number = project_number;
    }

    public String getName_of_project() {
        return name_of_project;
    }

    public void setName_of_project(String name_of_project) {
        this.name_of_project = name_of_project;
    }

    public CustomerResponseDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponseDto customer) {
        this.customer = customer;
    }

    public Integer getRelease_version() {
        return release_version;
    }

    public void setRelease_version(Integer release_version) {
        this.release_version = release_version;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }
}
