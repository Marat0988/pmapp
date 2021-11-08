package com.ayupovmi.pmapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "releases")
public class ReleaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long releaseId;


    @Column(name = "startDate")
    private LocalDateTime startDate;
    @Column(name = "endDate")
    private LocalDateTime endDate;

    public ReleaseEntity(){}

    public ReleaseEntity(Long releaseId, LocalDateTime endDate, LocalDateTime startDate) {
        this.releaseId = releaseId;
        this.endDate = endDate;
        this.startDate = startDate;
    }
    public Long getReleaseId() { return releaseId; }

    public void setReleaseId(Long releaseId) {this.releaseId = releaseId; }

    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public LocalDateTime getStartDate() { return startDate;}

    public void setStartDate(LocalDateTime startDate) {this.startDate = startDate;}

}
