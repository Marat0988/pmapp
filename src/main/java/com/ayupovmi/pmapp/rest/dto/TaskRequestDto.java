package com.ayupovmi.pmapp.rest.dto;


import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Задача")
public class TaskRequestDto {
    @Schema(description = "ID задачи")
    private long taskId;
    @Schema(description = "Название задачи")
    private String name;

    public TaskRequestDto(){}

    public TaskRequestDto(Long taskId, String name) {
        this.name = name;
        this.taskId= taskId;
    }

    public long getTaskId() {return taskId;}

    public void setTaskId(long taskId) {this.taskId = taskId;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
