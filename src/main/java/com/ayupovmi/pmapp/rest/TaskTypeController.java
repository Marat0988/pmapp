package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.rest.dto.TaskTypeRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskTypeResponseDto;
import com.ayupovmi.pmapp.service.TaskTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Типы задач", description = "Позволяет создать, получить или удалить по id тип задачи")
@RestController
@RequestMapping("/api/v1/taskTypes/")

public class TaskTypeController {

    private TaskTypeService taskTypeService;
    public TaskTypeController (TaskTypeService taskTypeService) {this.taskTypeService = taskTypeService;}
    //get
    @Operation(description = "Позволяет получить по id тип задачи")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskTypeResponseDto> getTaskType(@PathVariable (required = false) Long taskTypeId,
                                                       @RequestBody TaskTypeRequestDto taskTypeRequestDto){
        if(taskTypeId != null){
            TaskTypeResponseDto taskTypeResponseDto = taskTypeService.getById(taskTypeId);
            return ResponseEntity.ok().body(taskTypeResponseDto);
        } else {
            return new ResponseEntity<TaskTypeResponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать тип задачи")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskTypeResponseDto> saveTaskType(@RequestBody TaskTypeRequestDto taskTypeRequestDto){
        TaskTypeResponseDto taskTypeResponseDto = taskTypeService.save(taskTypeRequestDto);
        return ResponseEntity.ok().body(taskTypeResponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id тип задачи")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskTypeResponseDto> deleteTaskType(@PathVariable (required = false) Long taskTypeId,
                                                      @RequestBody TaskTypeRequestDto taskTypeRequestDto){
        TaskTypeResponseDto taskTypeResponseDto = this.taskTypeService.getById(taskTypeId);
        if(taskTypeResponseDto != null){
            this.taskTypeService.delete(taskTypeId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<TaskTypeResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id тип задачи")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskTypeResponseDto> updateTaskType(@PathVariable (required = false) Long taskTypeId,
                                                      @RequestBody TaskTypeRequestDto taskTypeRequestDto){

        if(taskTypeId != null){
            TaskTypeResponseDto taskTypeResponseDto = taskTypeService.save(taskTypeRequestDto);
            return ResponseEntity.ok().body(taskTypeResponseDto);
        }
        return new ResponseEntity<TaskTypeResponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех типов задач")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskTypeResponseDto>> getAllTaskTypes () {
        List<TaskTypeResponseDto> taskTypeResponseDtoList = taskTypeService.getAll();
        if (taskTypeResponseDtoList.isEmpty()) {return new ResponseEntity<List<TaskTypeResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(taskTypeResponseDtoList);


    }
}
