package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.model.Role;
import com.ayupovmi.pmapp.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для ролей пользователей", description = "Позволяет создать, получить или удалить по id роли пользователей")
@RestController
@RequestMapping("/api/v1/roles/")
@ResponseStatus
public class RoleController {
    @Autowired
    private RoleService roleService;
    //get
    @Tag(name = "Метод контроллера для получения роли", description = "Позволяет получить по id роль пользователя")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getTask(@PathVariable("id") Long roleId){
        if(roleId == null){
            return new ResponseEntity<Role>(HttpStatus.BAD_REQUEST);
        }
        Role role = roleService.getById(roleId);
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания роли", description = "Позволяет создать роль пользователя")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> saveRole(@RequestBody @Validated Role role){
        if(role == null){
            return new ResponseEntity<Role>(HttpStatus.BAD_REQUEST);
        }
        this.roleService.save(role);
        return new ResponseEntity<Role>(role, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления роли", description = "Позволяет удалить по id роль пользователя")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> deleteRole(@PathVariable("id") Long id){
        Role role = this.roleService.getById(id);
        if(role == null){
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        this.roleService.delete(id);
        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }

}
