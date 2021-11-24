package com.ayupovmi.pmapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column (nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "roleForSecurity")
    private RoleForSecurity roleForSecurity;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "statusForSecurity")
    private StatusForSecurity statusForSecurity;

    @OneToMany (targetEntity = RoleEntity.class,  fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "roleId")
    private List<RoleEntity> roleEntityList;

    public UserEntity(){}



    public UserEntity(Long id, String name, String lastName, String password, String email) {
        this.userId = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() { return userId; }

    public void setUserId(Long id) { this.userId = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public RoleForSecurity getRoleForSecurity() {return roleForSecurity;}
    public void setRoleForSecurity(RoleForSecurity roleForSecurity) {this.roleForSecurity = roleForSecurity;}

    public StatusForSecurity getStatusForSecurity() {return statusForSecurity;}

    public void setStatusForSecurity(StatusForSecurity statusForSecurity) {this.statusForSecurity = statusForSecurity;}
}
