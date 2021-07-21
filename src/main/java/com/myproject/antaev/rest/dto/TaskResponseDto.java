package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача (ответ)")
public class TaskResponseDto {

    @Schema(description = "ID проекта")
    private int project_number;
    @Schema(description = "Версия релиза")
    private int release_version;
    @Schema(description = "ID задачи")
    private int task_number;
    @Schema(description = "Создатель задачи")
    private UserResponseDto author;
    @Schema(description = "Исполнитель задачи")
    private UserResponseDto performer;
    @Schema(description = "Имя задачи")
    private String task_name;
    @Schema(description = "Статус задачи")
    private StatusTask task_status;

    public TaskResponseDto(int project_number, int release_version, int task_number, UserResponseDto author, String task_name, StatusTask task_status) {
        this.project_number = project_number;
        this.release_version = release_version;
        this.task_number = task_number;
        this.author = author;
        this.performer = performer;
        this.task_name = task_name;
        this.task_status = task_status;
    }

    public int getProject_number() {
        return project_number;
    }

    public int getRelease_version() {
        return release_version;
    }

    public int getTask_number() {
        return task_number;
    }

    public UserResponseDto getAuthor() {
        return author;
    }

    public UserResponseDto getPerformer() {
        return author;
    }

    public String getTask_name() {
        return task_name;
    }

    public StatusTask getTask_status() {
        return task_status;
    }

}
