package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Роль пользователя")
public class StatusRequestDto {

    @Schema(description = "ID роли пользователя")
    private Long statusId;

    @Schema(description = "Имя роли пользователя")
    private String name;

    public StatusRequestDto(){}

    public StatusRequestDto(Long statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Long getStatusId() { return statusId; }

    public void setStatusId(Long statusId) { this.statusId = statusId; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
