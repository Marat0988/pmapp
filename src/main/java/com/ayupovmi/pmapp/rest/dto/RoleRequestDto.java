package com.ayupovmi.pmapp.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Роль пользователя")
public class RoleRequestDto {
    @Schema(description = "ID роли пользователя")
    private Long roleId;
    @Schema(description = "Имя роли пользователя")
    private String name;

    public RoleRequestDto (){}

    public RoleRequestDto(Long roleId, String name) {
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
