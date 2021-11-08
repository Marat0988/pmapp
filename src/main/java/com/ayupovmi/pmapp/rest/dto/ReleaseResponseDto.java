package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Релиз")
public class ReleaseResponseDto {

    @Schema(description = "Начало релиза")
    private LocalDateTime startDate;
    @Schema(description = "Окончание релиза")
    private LocalDateTime endDate;

    ReleaseResponseDto(){}

    public ReleaseResponseDto(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public LocalDateTime getStartDate() { return startDate;}

    public void setStartDate(LocalDateTime startDate) {this.startDate = startDate;}

}
