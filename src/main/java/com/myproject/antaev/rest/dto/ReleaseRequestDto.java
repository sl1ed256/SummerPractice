package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Проект (запрос)")
public class ReleaseRequestDto {

    @Schema(description = "ID проекта")
    private int projectNumber;
    @Schema(description = "Версия релиза")
    private int releaseVersion;
    @Schema(description = "Дата начала релиза")
    private Date startTime;
    @Schema(description = "Дата конца релиза")
    private Date endTime;

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(int releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Date getStartTime() {
        return startTime;
    }
    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
