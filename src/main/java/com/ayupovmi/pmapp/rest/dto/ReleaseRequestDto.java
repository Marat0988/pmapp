package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Релиз")
public class ReleaseRequestDto {
    @Schema(description = "ID релиза")
    private Long releaseId;

    ReleaseRequestDto(){}

    public ReleaseRequestDto(Long releaseId) {
        this.releaseId = releaseId;
    }

    public Long getReleaseId() { return releaseId; }

    public void setReleaseId(Long releaseId) {this.releaseId = releaseId; }
}
