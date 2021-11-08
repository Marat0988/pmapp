package com.ayupovmi.pmapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

    @Column(name = "name")
    private String name;
    private Boolean is_paid;

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}