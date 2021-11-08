package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Роль пользователя")
public class StatusReponseDto {

    @Schema(description = "Имя роли пользователя")
    private String name;

    public StatusReponseDto(){}

    public StatusReponseDto(Long statusId, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
