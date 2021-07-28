package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusProject;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект (ответ)")
public class ProjectResponseDto {
    @Schema(description = "ID проекта")
    private int projectNumber;
    @Schema(description = "Наименование проекта")
    private String nameOfProject;
    @Schema(description = "Заказчик")
    private CustomerResponseDto customer;
    @Schema(description = "Версия релиза")
    private int releaseVersion;
    @Schema(description = "Статус проекта")
    private StatusProject status;

    public ProjectResponseDto(int projectNumber, String nameOfProject, CustomerResponseDto customer, Integer releaseVersion, StatusProject status) {
        this.projectNumber = projectNumber;
        this.nameOfProject = nameOfProject;
        this.customer = customer;
        this.releaseVersion = releaseVersion;
        this.status = status;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public CustomerResponseDto getCustomer() {
        return customer;
    }

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public StatusProject getStatus() {
        return status;
    }

}
