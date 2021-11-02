package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.model.Task;
import com.ayupovmi.pmapp.model.TaskType;
import com.ayupovmi.pmapp.service.TaskService;
import com.ayupovmi.pmapp.service.TaskTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для типов задач", description = "Позволяет создать, получить или удалить по id тип задачи")
@RestController
@RequestMapping("/api/v1/taskTypes/")
@ResponseStatus
public class TaskTypeController {

    @Autowired
    private TaskTypeService taskTypeService;
    //get
    @Tag(name = "Метод контроллера для получения типа задачи", description = "Позволяет получить по id тип задачи")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskType> getTaskType(@PathVariable("id") Long taskTypeId){
        if(taskTypeId == null){
            return new ResponseEntity<TaskType>(HttpStatus.BAD_REQUEST);
        }
        TaskType taskType = taskTypeService.getById(taskTypeId);
        return new ResponseEntity<TaskType>(taskType, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания типа задачи", description = "Позволяет создать тип задачи")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskType> saveTaskType(@RequestBody @Validated TaskType taskType){
        if(taskType == null){
            return new ResponseEntity<TaskType>(HttpStatus.BAD_REQUEST);
        }
        this.taskTypeService.save(taskType);
        return new ResponseEntity<TaskType>(taskType, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления типа задачи", description = "Позволяет удалить по id тип задачи")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskType> deleteTaskType(@PathVariable("id") Long id){
        TaskType taskType = this.taskTypeService.getById(id);
        if(taskType == null){
            return new ResponseEntity<TaskType>(HttpStatus.NOT_FOUND);
        }
        this.taskTypeService.delete(id);
        return new ResponseEntity<TaskType>(HttpStatus.NO_CONTENT);
    }
}
