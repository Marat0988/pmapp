package com.ayupovmi.pmapp.rest;


import com.ayupovmi.pmapp.rest.dto.StatusReponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusRequestDto;
import com.ayupovmi.pmapp.service.StatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Статусы задач", description = "Позволяет создать, получить или удалить по id статусы")
@RestController
@RequestMapping("/api/v1/statuses/")

public class StatusController {

    private StatusService statusService;
    public StatusController (StatusService statusService) {this.statusService = statusService;}
    //get
    @Operation(description = "Позволяет получить по id статус пользователя")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusReponseDto> getStatus(@PathVariable (required = false) Long statusId,
                                                    @RequestBody StatusRequestDto statusRequestDto){
        if(statusId != null){
            StatusReponseDto statusReponseDto = statusService.getById(statusId);
            return ResponseEntity.ok().body(statusReponseDto);
        } else {
            return new ResponseEntity<StatusReponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать статус пользователя")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusReponseDto> saveStatus(@RequestBody StatusRequestDto statusRequestDto){
        StatusReponseDto statusReponseDto = statusService.save(statusRequestDto);
        return ResponseEntity.ok().body(statusReponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id статус пользователя")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusReponseDto> deleteStatus(@PathVariable (required = false) Long statusId,
                                                      @RequestBody StatusRequestDto statusRequestDto){
        StatusReponseDto statusReponseDto = this.statusService.getById(statusId);
        if(statusReponseDto != null){
            this.statusService.delete(statusId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<StatusReponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id статус пользователя")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusReponseDto> updateStatus(@PathVariable (required = false) Long statusId,
                                                      @RequestBody StatusRequestDto statusRequestDto){

        if(statusId != null){
            StatusReponseDto statusReponseDto = statusService.save(statusRequestDto);
            return ResponseEntity.ok().body(statusReponseDto);
        }
        return new ResponseEntity<StatusReponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех статусов пользователей")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StatusReponseDto>> getAllStatuses () {
        List<StatusReponseDto> statusReponseDtoList = statusService.getAll();
        if (statusReponseDtoList.isEmpty()) {return new ResponseEntity<List<StatusReponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(statusReponseDtoList);

    }
}
