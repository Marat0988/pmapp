package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.model.Project;
import com.ayupovmi.pmapp.model.ProjectDto;
import com.ayupovmi.pmapp.model.Status;
import com.ayupovmi.pmapp.service.ProjectService;
import com.ayupovmi.pmapp.service.StatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для  проектов", description = "Позволяет создать, получить или удалить по id проекты")
@RestController
@RequestMapping("/api/v1/projects/")
@ResponseStatus
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    //get
    @Tag(name = "Метод контроллера для получения проекта", description = "Позволяет получить по id проект")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> getProjectDto(@PathVariable("id") Long projectDtoId){
        if(projectDtoId == null){
            return new ResponseEntity<ProjectDto>(HttpStatus.BAD_REQUEST);
        }
        ProjectDto projectDto = projectService.getById(projectDtoId);
        return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.OK);
    }
    //post
    @Tag(name = "Метод контроллера для создания проекта", description = "Позволяет создать проект")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> saveProjectDto(@RequestBody @Validated ProjectDto projectDto){
        if(projectDto == null){
            return new ResponseEntity<ProjectDto>(HttpStatus.BAD_REQUEST);
        }
        this.projectService.save(projectDto);
        return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.CREATED);
    }
    //delete
    @Tag(name = "Метод контроллера для удаления проекта", description = "Позволяет удалить по id проект")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> deleteProjectDto(@PathVariable("id") Long id){
        ProjectDto projectDto = this.projectService.getById(id);
        if(projectDto == null){
            return new ResponseEntity<ProjectDto>(HttpStatus.NOT_FOUND);
        }
        this.projectService.delete(id);
        return new ResponseEntity<ProjectDto>(HttpStatus.NO_CONTENT);
    }
}
