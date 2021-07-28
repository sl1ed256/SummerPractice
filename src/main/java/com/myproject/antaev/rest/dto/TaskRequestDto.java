package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача (запрос)")
public class TaskRequestDto {
    @Schema(description = "ID проекта")
    private int projectNumber;
    @Schema(description = "Версия релиза")
    private int releaseVersion;
    @Schema(description = "ID задачи")
    private int taskNumber;

    @Schema(description = "Создатель задачи")
    private UserResponseDto author;
    @Schema(description = "Исполнитель задачи")
    private UserResponseDto performer;
    @Schema(description = "Имя задачи")
    private String taskName;
    @Schema(description = "Статус задачи")
    private StatusTask taskStatus;

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(int releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public UserResponseDto getAuthor() {
        return author;
    }

    public void setAuthor(UserResponseDto author) {
        this.author = author;
    }

    public UserResponseDto getPerformer() {
        return performer;
    }

    public void setPerformer(UserResponseDto performer) {
        this.performer = performer;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public StatusTask getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(StatusTask taskStatus) {
        this.taskStatus = taskStatus;
    }

}
