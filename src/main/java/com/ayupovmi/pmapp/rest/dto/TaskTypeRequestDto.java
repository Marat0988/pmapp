package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Тип задачи")
public class TaskTypeRequestDto {
    @Schema(description = "ID типа задачи")
    private Long taskTypeId;
    @Schema(description = "Имя типа задачи")
       private String name;
    public TaskTypeRequestDto(){}

    public TaskTypeRequestDto(String name) {
        this.taskTypeId = taskTypeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getTaskTypeId() { return taskTypeId; }

    public void setTaskTypeId(Long taskTypeId) { this.taskTypeId = taskTypeId; }

}
