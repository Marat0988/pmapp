package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;
import com.ayupovmi.pmapp.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Проекты", description = "Позволяет создать, получить или удалить по id проекты")
@RestController
@RequestMapping("/api/v1/projects/")

public class ProjectController {

    private ProjectService projectService;
    public ProjectController (ProjectService  projectService) {this.projectService = projectService;}
    //get
    @Operation(description = "Позволяет получить по id проект")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable (required = false) Long projectId,
                                                            @RequestBody ProjectRequestDto projectRequestDto){
        if(projectId != null){
            ProjectResponseDto projectResponseDto = projectService.getById(projectId);
            return ResponseEntity.ok().body(projectResponseDto);
        } else {
        return new ResponseEntity<ProjectResponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать проект")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponseDto> saveProject(@RequestBody ProjectRequestDto projectRequestDto){
        ProjectResponseDto projectResponseDto = projectService.save(projectRequestDto);
       return ResponseEntity.ok().body(projectResponseDto);
    }
    //delete
    @Operation(description = "Позволяет удалить по id проект")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponseDto> deleteProject(@PathVariable (required = false) Long projectId,
                                                               @RequestBody ProjectRequestDto projectRequestDto){
        ProjectResponseDto projectResponseDto = this.projectService.getById(projectId);
        if(projectResponseDto != null){
            this.projectService.delete(projectId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<ProjectResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id проект")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable (required = false) Long projectId,
                                                            @RequestBody ProjectRequestDto projectRequestDto){

        if(projectId != null){
            ProjectResponseDto projectResponseDto = projectService.save(projectRequestDto);
            return ResponseEntity.ok().body(projectResponseDto);
        }
        return new ResponseEntity<ProjectResponseDto>(HttpStatus.NOT_FOUND);
    }

    //get all
    @Operation(description = "Позволяет получить список всех проектов")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects () {
        List<ProjectResponseDto> projectResponseDtoList = projectService.getAll();
        if (projectResponseDtoList.isEmpty()) {return new ResponseEntity<List<ProjectResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(projectResponseDtoList);


    }

}
