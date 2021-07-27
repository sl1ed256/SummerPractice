package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача (ответ)")
public class TaskResponseDto {

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

    public TaskResponseDto(int projectNumber, int releaseVersion, int taskNumber, UserResponseDto author, String taskName, StatusTask taskStatus) {
        this.projectNumber = projectNumber;
        this.releaseVersion = releaseVersion;
        this.taskNumber = taskNumber;
        this.author = author;
        this.performer = performer;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public UserResponseDto getAuthor() {
        return author;
    }

    public UserResponseDto getPerformer() {
        return author;
    }

    public String getTaskName() {
        return taskName;
    }

    public StatusTask getTaskStatus() {
        return taskStatus;
    }

}
