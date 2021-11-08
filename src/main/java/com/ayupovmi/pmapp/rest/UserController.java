package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.exception.UserNameNotFoundException;
import com.ayupovmi.pmapp.rest.dto.UserRequestDto;
import com.ayupovmi.pmapp.rest.dto.UserResponseDto;
import com.ayupovmi.pmapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Пользователи", description = "Позволяет создать, получить или удалить по id пользователей")
@RestController
@RequestMapping("/api/v1/users/")

public class UserController {

    private UserService userService;
    public UserController (UserService userService) {this.userService = userService;}
    //get
    @Operation(description = "Позволяет получить по id пользователя")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> getUser(@PathVariable (required = false) Long userId,
                                                   @RequestBody UserRequestDto userRequestDto) {
        if(userId != null){
            UserResponseDto userResponseDto = userService.getById(userId);
            return ResponseEntity.ok().body(userResponseDto);
        } else {
            return new ResponseEntity<UserResponseDto>(HttpStatus.BAD_REQUEST);
            }
    }
    //post
    @Operation(description = "Позволяет создать пользователя")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.save(userRequestDto);
        return ResponseEntity.ok().body(userResponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id пользователя")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable (required = false) Long userId,
                                                      @RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = this.userService.getById(userId);
        if(userResponseDto != null){
            this.userService.delete(userId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<UserResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id пользователя")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable (required = false) Long userId,
                                                      @RequestBody UserRequestDto userRequestDto){

        if(userId != null){
            UserResponseDto userResponseDto = userService.save(userRequestDto);
            return ResponseEntity.ok().body(userResponseDto);
        }
        return new ResponseEntity<UserResponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех пользователей")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDto>> getAllUsers () {
        List<UserResponseDto> userResponseDtoList = userService.getAll();
        if (userResponseDtoList.isEmpty()) {return new ResponseEntity<List<UserResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(userResponseDtoList);


    }

}


