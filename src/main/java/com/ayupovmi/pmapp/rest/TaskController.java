package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.rest.dto.TaskRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;
import com.ayupovmi.pmapp.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Задачи", description = "Позволяет создать, получить или удалить по id задачи")
@RestController
@RequestMapping("/api/v1/tasks/")

public class TaskController {

    private TaskService taskService;
    public TaskController (TaskService taskService) {this.taskService = taskService;}
    //get
    @Operation(description = "Позволяет получить по id задачу")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable (required = false) Long taskId,
                                                         @RequestBody TaskRequestDto taskRequestDto){
        if(taskId != null){
            TaskResponseDto taskResponseDto = taskService.getById(taskId);
            return ResponseEntity.ok().body(taskResponseDto);
        } else {
            return new ResponseEntity<TaskResponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать задачу")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseDto> saveTask(@RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto taskResponseDto = taskService.save(taskRequestDto);
        return ResponseEntity.ok().body(taskResponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id задачу")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseDto> deleteTask(@PathVariable (required = false) Long taskId,
                                                            @RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto taskResponseDto = this.taskService.getById(taskId);
        if(taskResponseDto != null){
            this.taskService.delete(taskId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<TaskResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id задачу")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable (required = false) Long taskId,
                                                            @RequestBody TaskRequestDto taskRequestDto){

        if(taskId != null){
            TaskResponseDto taskResponseDto = taskService.save(taskRequestDto);
            return ResponseEntity.ok().body(taskResponseDto);
        }
        return new ResponseEntity<TaskResponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех задач")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskResponseDto>> getAllTasks () {
        List<TaskResponseDto> taskResponseDtoList = taskService.getAll();
        if (taskResponseDtoList.isEmpty()) {return new ResponseEntity<List<TaskResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(taskResponseDtoList);


    }

}
