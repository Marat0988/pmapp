package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectRequestDto {

    @Schema(description = "ID проекта")
    private long projectId;
    @Schema(description = "Название проекта")
    private String name;

    public ProjectRequestDto(){}

    public ProjectRequestDto(long projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
