package com.ayupovmi.pmapp.entity;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column (unique = true, nullable = false)
    private String name;

    public RoleEntity(){}

    public RoleEntity(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
