package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача (запрос)")
public class TaskRequestDto {
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

    public int getTask_number() {
        return task_number;
    }

    public void setTask_number(int task_number) {
        this.task_number = task_number;
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

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public StatusTask getTask_status() {
        return task_status;
    }

    public void setTask_status(StatusTask task_status) {
        this.task_status = task_status;
    }

}
