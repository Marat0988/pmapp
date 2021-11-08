package com.ayupovmi.pmapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "taskTypes")
public class TaskTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskTypeId;

    @Column
    private String name;

    public TaskTypeEntity(){}

    public TaskTypeEntity(Long taskTypeId, String name) {
        this.taskTypeId = taskTypeId;
        this.name = name;
    }

    public Long getTaskTypeId() { return taskTypeId; }

    public void setTaskTypeId(Long taskTypeId) { this.taskTypeId = taskTypeId; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
