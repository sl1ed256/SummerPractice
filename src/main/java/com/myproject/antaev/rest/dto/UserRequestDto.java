package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.UserRights;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Пользователь (запрос)")
public class UserRequestDto {

    @Schema(description = "ID пользователя")
    private int userId;

    @Schema(description = "Имя пользователя")
    private String nameUser;
    @Schema(description = "Роли пользователя")
    private List<UserRights> userRights;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public List<UserRights> getRoles() {
        return userRights;
    }

    public void setRoles(List<UserRights> userRights) {
        this.userRights = userRights;
    }


}
