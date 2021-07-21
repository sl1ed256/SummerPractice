package com.myproject.antaev.rest.dto;

import com.myproject.antaev.rest.data_type.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Пользователь (запрос)")
public class UserRequestDto {

    @Schema(description = "ID пользователя")
    private int user_id;

    @Schema(description = "Имя пользователя")
    private String name_user;
    @Schema(description = "Роли пользователя")
    private List<Role> roles;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
