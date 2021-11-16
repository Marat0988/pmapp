package com.ayupovmi.pmapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column (unique = true, nullable = false)
    private String name;

    @Column (name = "isPaid")
    private Boolean isPaid;

    @OneToMany (targetEntity = StatusEntity.class,  fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "statusId")
    private List<StatusEntity> statusEntityList;

    @OneToMany (targetEntity = UserEntity.class,  fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "userId")
    private List<UserEntity> userEntityList;

    public ProjectEntity () {}

    public ProjectEntity(Long projectId, String name, Boolean isPaid) {
        this.projectId = projectId;
        this.name = name;
        this.isPaid = isPaid;

    }

    public Long getProjectId() { return projectId; }

    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

   }