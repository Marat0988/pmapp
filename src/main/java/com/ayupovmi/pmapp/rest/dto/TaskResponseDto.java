package com.ayupovmi.pmapp.rest.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
@Schema(description = "Задача")
public class TaskResponseDto {
    @Schema(description = "Название задачи")
    private String name;
    @Schema(description = "Описание задачи")
    private String description;
    @Schema(description = "Дата и время выполнения задачи")
    private LocalDateTime submissionDate;
    @Schema(description = "Дата и время начала задачи")
    private LocalDateTime startDate;

    public TaskResponseDto(){}

    public TaskResponseDto(String name, String description, LocalDateTime submissionDate, LocalDateTime startDate) {
        this.name = name;
        this.description = description;
        this.submissionDate = submissionDate;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public LocalDateTime getSubmissionDate() {return submissionDate;}
    public void setSubmissionDate(LocalDateTime submissionDate) {this.submissionDate = submissionDate;}
    public LocalDateTime getStartDate() {return startDate;}
    public void setStartDate(LocalDateTime startDate) {this.startDate = startDate;}
}
