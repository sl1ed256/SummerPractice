package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.UserRights;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Пользователи (ответ)")
public class UserResponseDto {
    @Schema(description = "ID пользователя")
    private int userId;
    @Schema(description = "Имя пользователя")
    private String nameUser;
    @Schema(description = "Права пользователя")
    private List<UserRights> userRights;

    public UserResponseDto(int userId, String nameUser, List<UserRights> userRights) {
        this.userId = userId;
        this.nameUser = nameUser;
        this.userRights = userRights;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public List<com.myproject.antaev.rest.data_type.UserRights> getRoles() {
        return userRights;
    }

    public void setRoles(List<com.myproject.antaev.rest.data_type.UserRights> userRights) {
        this.userRights = userRights;
    }
}
