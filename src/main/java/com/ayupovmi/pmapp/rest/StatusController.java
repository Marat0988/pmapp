package com.ayupovmi.pmapp.rest;


import com.ayupovmi.pmapp.model.Status;
import com.ayupovmi.pmapp.service.StatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для  статусов", description = "Позволяет создать, получить или удалить по id статусы")
@RestController
@RequestMapping("/api/v1/statuses/")
@ResponseStatus
public class StatusController {

    @Autowired
    private StatusService statusService;
    //get
    @Tag(name = "Метод контроллера для получения статуса", description = "Позволяет получить по id статус")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> getStatus(@PathVariable("id") Long statusId){
        if(statusId == null){
            return new ResponseEntity<Status>(HttpStatus.BAD_REQUEST);
        }
        Status status = statusService.getById(statusId);
        return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания статуса", description = "Позволяет создать статус")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Status> saveStatus(@RequestBody @Validated Status status){
        if(status == null){
            return new ResponseEntity<Status>(HttpStatus.BAD_REQUEST);
        }
        this.statusService.save(status);
        return new ResponseEntity<Status>(status, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления статуса", description = "Позволяет удалить по id статус")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> deleteStatus(@PathVariable("id") Long id){
        Status status = this.statusService.getById(id);
        if(status == null){
            return new ResponseEntity<Status>(HttpStatus.NOT_FOUND);
        }
        this.statusService.delete(id);
        return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
    }
}
