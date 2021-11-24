package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "роли пользователей", description = "Позволяет создать, получить или удалить по id роли пользователей")
@RestController
@RequestMapping("/api/v1/roles/")

public class RoleController {
    private RoleService roleService;
    public RoleController (RoleService roleService) {this.roleService = roleService;}
    //get
    @Operation(description = "Позволяет получить по id роль пользователя")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable (required = false) Long roleId,
                                                   @RequestBody RoleRequestDto roleRequestDto){
        if(roleId != null){
            RoleResponseDto roleResponseDto = roleService.getById(roleId);
            return ResponseEntity.ok().body(roleResponseDto);
        } else {
            return new ResponseEntity<RoleResponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать роль пользователя")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<RoleResponseDto> saveRole(@RequestBody RoleRequestDto roleRequestDto){
        RoleResponseDto roleResponseDto = roleService.save(roleRequestDto);
        return ResponseEntity.ok().body(roleResponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id роль пользователя")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<RoleResponseDto> deleteRole(@PathVariable (required = false) Long roleId,
                                                      @RequestBody RoleRequestDto roleRequestDto){
        RoleResponseDto roleResponseDto = this.roleService.getById(roleId);
        if(roleResponseDto != null){
            this.roleService.delete(roleId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<RoleResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id роль пользователя")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<RoleResponseDto> updateRole(@PathVariable (required = false) Long roleId,
                                                      @RequestBody RoleRequestDto roleRequestDto){

        if(roleId != null){
            RoleResponseDto roleResponseDto = roleService.save(roleRequestDto);
            return ResponseEntity.ok().body(roleResponseDto);
        }
        return new ResponseEntity<RoleResponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех ролей пользователей")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles () {
        List<RoleResponseDto> roleResponseDtoList = roleService.getAll();
        if (roleResponseDtoList.isEmpty()) {return new ResponseEntity<List<RoleResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(roleResponseDtoList);

    }

}
