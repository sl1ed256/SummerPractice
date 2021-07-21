package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Проект (ответ)")
public class ReleaseResponseDto {
    @Schema(description = "ID проекта")
    private int project_number;
    @Schema(description = "Версия релиза")
    private int release_version;
    @Schema(description = "Дата начала релиза")
    private Date start_time;
    @Schema(description = "Дата конца релиза")
    private Date end_time;

    public ReleaseResponseDto(int project_number, int release_version, Date start_time, Date end_time) {
        this.project_number = project_number;
        this.release_version = release_version;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getProject_number() {
        return project_number;
    }

    public void setProject_number(int project_number) {
        this.project_number = project_number;
    }

    public int getRelease_version() {
        return release_version;
    }

    public void setRelease_version(int release_version) {
        this.release_version = release_version;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
