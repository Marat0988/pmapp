package com.ayupovmi.pmapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column
    private String name;


    public StatusEntity (){}

    public StatusEntity(Long statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Long getStatusId() { return statusId; }

    public void setStatusId(Long statusId) { this.statusId = statusId; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
