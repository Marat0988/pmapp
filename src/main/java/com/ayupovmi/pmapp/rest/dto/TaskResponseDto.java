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
    @Schema(description = "Тип задачи")
    private TaskTypeResponseDto taskTypeResponseDto;
    @Schema(description = "Релиз задачи")
    private ReleaseResponseDto releaseResponseDto;
    @Schema(description = "Статус задачи")
    private StatusReponseDto statusResponseDto;
    @Schema(description = "Исполнтель задачи")
    private UserResponseDto userResponseDto;

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

    public UserResponseDto getUserResponseDto() {return userResponseDto;}

    public void setUserResponseDto(UserResponseDto userResponseDto) {this.userResponseDto = userResponseDto;}

    public TaskTypeResponseDto getTaskTypeResponseDto() {return taskTypeResponseDto;}

    public void setTaskTypeResponseDto(TaskTypeResponseDto taskTypeResponseDto) {
        this.taskTypeResponseDto = taskTypeResponseDto;}

    public ReleaseResponseDto getReleaseResponseDto() {return releaseResponseDto;}

    public void setReleaseResponseDto(ReleaseResponseDto releaseResponseDto) {
        this.releaseResponseDto = releaseResponseDto;}

    public StatusReponseDto getStatusResponseDto() {return statusResponseDto;}

    public void setStatusResponseDto(StatusReponseDto statusResponseDto) {
        this.statusResponseDto = statusResponseDto;}
}
