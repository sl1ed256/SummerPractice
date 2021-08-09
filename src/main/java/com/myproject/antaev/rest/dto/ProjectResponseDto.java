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
    private int customer;
    @Schema(description = "Версия релиза")
    private int releaseVersion;
    @Schema(description = "Статус проекта")
    private StatusProject status;

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(int releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }


}
