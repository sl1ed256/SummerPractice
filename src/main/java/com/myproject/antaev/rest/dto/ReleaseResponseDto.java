package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Проект (ответ)")
public class ReleaseResponseDto {
    @Schema(description = "ID проекта")
    private int projectNumber;
    @Schema(description = "Версия релиза")
    private int releaseVersion;
    @Schema(description = "Дата начала релиза")
    private Date startTime;
    @Schema(description = "Дата конца релиза")
    private Date endTime;

    public ReleaseResponseDto(int project_number, int releaseVersion, Date startTime, Date endTime) {
        this.projectNumber = project_number;
        this.releaseVersion = releaseVersion;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getProject_number() {
        return projectNumber;
    }

    public void setProject_number(int project_number) {
        this.projectNumber = project_number;
    }

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(int releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Date getStartTime() {
        return startTime;
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
