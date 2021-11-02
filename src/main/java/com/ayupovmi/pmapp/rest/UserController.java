package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.model.User;
import com.ayupovmi.pmapp.model.UserDto;
import com.ayupovmi.pmapp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для пользователей", description = "Позволяет создать, получить или удалить по id пользователя")
@RestController
@RequestMapping("/api/v1/users/")
@ResponseStatus
public class UserController {
    @Autowired
    private UserService userService;
    //get
    @Tag(name = "Метод контроллера для получения пользователя", description = "Позволяет получить по id пользователя")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserDto(@PathVariable("id") Long userDtoId){
        if(userDtoId == null){
            return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
        }
        UserDto userDto = userService.getById(userDtoId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания пользователя", description = "Позволяет создать пользователя")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> saveUserDto(@RequestBody @Validated UserDto userDto){
        if(userDto == null){
            return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
        }
        this.userService.save(userDto);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления пользователя", description = "Позволяет удалить по id пользователя")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> deleteUserDto(@PathVariable("id") Long id){
        UserDto userDto = this.userService.getById(id);
        if(userDto == null){
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        this.userService.delete(id);
        return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
    }
}
