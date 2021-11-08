package com.ayupovmi.pmapp.rest;

import com.ayupovmi.pmapp.entity.ReleaseEntity;
import com.ayupovmi.pmapp.rest.dto.ReleaseRequestDto;
import com.ayupovmi.pmapp.rest.dto.ReleaseResponseDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Релиз", description = "Позволяет создать, получить или удалить по id релизы")
@RestController
@RequestMapping("/api/v1/releases/")
public class ReleaseController {
    private ReleaseService releaseService;
    public ReleaseController (ReleaseService releaseService) {this.releaseService = releaseService;}
    //get
    @Operation(description = "Позволяет получить по id релиз")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReleaseResponseDto> getRelease (@PathVariable(required = false) Long releaseId,
                                                      @RequestBody ReleaseRequestDto releaseRequestDto){
        if(releaseId != null){
            ReleaseResponseDto releaseResponseDto = releaseService.getById(releaseId);
            return ResponseEntity.ok().body(releaseResponseDto);
        } else {
            return new ResponseEntity<ReleaseResponseDto>(HttpStatus.BAD_REQUEST);}
    }
    //post
    @Operation(description = "Позволяет создать релиз")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReleaseResponseDto> saveRelease(@RequestBody ReleaseRequestDto releaseRequestDto){
        ReleaseResponseDto releaseResponseDto = releaseService.save(releaseRequestDto);
        return ResponseEntity.ok().body( releaseResponseDto);



    }
    //delete
    @Operation(description = "Позволяет удалить по id релиз")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReleaseResponseDto> deleteRelease (@PathVariable (required = false) Long releaseId,
                                                      @RequestBody ReleaseRequestDto releaseRequestDto){
        ReleaseResponseDto releaseResponseDto = this.releaseService.getById(releaseId );
        if(releaseResponseDto != null){
            this.releaseService.delete(releaseId);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<ReleaseResponseDto>(HttpStatus.NOT_FOUND);
    }
    //update
    @Operation(description = "Позволяет обновить по id релиз")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReleaseResponseDto> updateRelease(@PathVariable (required = false) Long releaseId,
                                                      @RequestBody ReleaseRequestDto releaseRequestDto){

        if(releaseId != null){
            ReleaseResponseDto releaseResponseDto = releaseService.save(releaseRequestDto);
            return ResponseEntity.ok().body(releaseResponseDto);
        }
        return new ResponseEntity<ReleaseResponseDto>(HttpStatus.NOT_FOUND);
    }



    //get all
    @Operation(description = "Позволяет получить список всех релизов")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReleaseResponseDto>> getAllRoles () {
        List<ReleaseResponseDto> releaseResponseDtoList = releaseService.getAll();
        if (releaseResponseDtoList.isEmpty()) {return new ResponseEntity<List<ReleaseResponseDto>>(HttpStatus.NOT_FOUND);}
        return ResponseEntity.ok().body(releaseResponseDtoList);

    }

}

