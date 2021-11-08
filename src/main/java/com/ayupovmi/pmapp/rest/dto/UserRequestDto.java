package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserRequestDto {
    @Schema(description = "ID пользователя")
    private long userId;
    @Schema(description = "Имя пользователя")
    private String name;


    public UserRequestDto(){}

    public UserRequestDto(String name, String lastName, String password, String email) {
        this.userId = userId;
        this.name = name;
        }

    public Long getUserId() { return userId; }

    public void setUserId(Long id) { this.userId = userId; }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
