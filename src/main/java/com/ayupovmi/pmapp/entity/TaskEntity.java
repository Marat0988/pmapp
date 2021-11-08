package com.ayupovmi.pmapp.entity;
/**
* Simple Javabean domain object that represents Task.
*/

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "submissionDate")
    private LocalDateTime submissionDate;
    @Column(name = "startDate")
    private LocalDateTime startDate;

    @OneToMany (targetEntity = StatusEntity.class,  fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "statusId", referencedColumnName = "statusId")
    private List<StatusEntity> statusEntityList;

    @OneToMany (targetEntity = UserEntity.class)
    @JoinColumn (name = "userId", referencedColumnName = "userId")
    private UserEntity userEntity;

    @OneToMany  (targetEntity = ProjectEntity.class)
    @JoinColumn (name = "projectId", referencedColumnName = "projectId")
    private ProjectEntity projectEntity;

    @OneToMany  (targetEntity = ReleaseEntity.class)
    @JoinColumn (name = "releaseId", referencedColumnName = "releaseId")
    private ReleaseEntity releaseEntity;

    @OneToMany (targetEntity = TaskTypeEntity.class,  fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "taskTypeId", referencedColumnName = "taskTypeId")
    private List<TaskTypeEntity> taskTypeEntityList;


    public TaskEntity(){}

    public TaskEntity(Long taskId, String name, String description, LocalDateTime submissionDate, LocalDateTime startDate) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.submissionDate = submissionDate;
        this.startDate = startDate;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Long getTaskId() { return taskId; }

    public void setTaskId(Long id) { this.taskId = taskId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
