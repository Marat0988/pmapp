package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserResponseDto {
    @Schema(description = "Имя пользователя")
    private String name;
    @Schema(description = "Фамилия пользователя")
    private String lastName;
    @Schema(description = "Пароль пользователя")
    private String password;
    @Schema(description = "Почта пользователя")
    private String email;

    public UserResponseDto(){}

    public UserResponseDto(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
