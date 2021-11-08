package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Тип задачи")
public class TaskTypeResponseDto {
    @Schema(description = "Имя типа задачи")
       private String name;
    public TaskTypeResponseDto(){}

    public TaskTypeResponseDto(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
