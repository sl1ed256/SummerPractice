package com.myproject.antaev.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Проект (запрос)")
public class ReleaseRequestDto {
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

    public void setStart_time(Date start_time) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
