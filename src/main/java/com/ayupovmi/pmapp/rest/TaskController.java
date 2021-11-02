package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.model.Task;
import com.ayupovmi.pmapp.model.TaskDto;
import com.ayupovmi.pmapp.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Контроллер для задач", description = "Позволяет создать, получить или удалить по id задачу")
@RestController
@RequestMapping("/api/v1/tasks/")
@ResponseStatus
public class TaskController {

    @Autowired
    private TaskService taskService;
    //get
    @Tag(name = "Метод контроллера для получения задачи", description = "Позволяет получить по id задачу")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto>getTaskDto(@PathVariable("id") Long taskDtoId){
        if(taskDtoId == null){
            return new ResponseEntity<TaskDto>(HttpStatus.BAD_REQUEST);
        }
        TaskDto taskDto = taskService.getById(taskDtoId);
         return new ResponseEntity<TaskDto>(taskDto, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания задачи", description = "Позволяет создать задачу")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> saveTaskDto  (@RequestBody @Validated  TaskDto taskDto){
        if(taskDto == null){
            return new ResponseEntity<TaskDto>(HttpStatus.BAD_REQUEST);
        }
        this.taskService.save(taskDto);
        return new ResponseEntity<TaskDto>(taskDto, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления задачи", description = "Позволяет удалить по id задачу")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> deleteTaskDto(@PathVariable("id") Long id){
        TaskDto taskDto = this.taskService.getById(id);
        if(taskDto == null){
            return new ResponseEntity<TaskDto>(HttpStatus.NOT_FOUND);
        }
        this.taskService.delete(id);
        return new ResponseEntity<TaskDto>(HttpStatus.NO_CONTENT);
    }
}
