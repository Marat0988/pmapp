package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectResponseDto  {
    @Schema(description = "Название проекта")
    private String name;
    @Schema(description = "Оплачиваемость проекта")
    private Boolean isPaid;

    public ProjectResponseDto(){}

    public ProjectResponseDto(String name, Boolean isPaid) {
        this.name = name;
        this.isPaid = isPaid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
}