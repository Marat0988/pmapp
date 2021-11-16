package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.rest.dto.*;
import com.ayupovmi.pmapp.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetTaskImpl implements SetTask {
    private TaskService taskService;
    public  SetTaskImpl (TaskService taskService) {this.taskService = taskService;}
    private UserService userService;
    public  SetTaskImpl (UserService userService) {this.userService = userService;}
    private StatusService statusService;
    public  SetTaskImpl (StatusService statusService) {this.statusService = statusService;}
    private ReleaseService releaseService;
    public  SetTaskImpl (ReleaseService releaseService) {this.releaseService = releaseService;}
    private TaskTypeService taskTypeService;
    public  SetTaskImpl (TaskTypeService taskTypeService) {this.taskTypeService =taskTypeService;}
    @Transactional
    @Override
    public TaskResponseDto setUser(Long taskId, Long userId) {
        UserResponseDto userResponseDto = userService.getById(userId);
        TaskResponseDto taskResponseDto = taskService.getById(taskId);
        taskResponseDto.setUserResponseDto(userResponseDto);
        return taskResponseDto;
    }
    @Transactional
    @Override
    public TaskResponseDto setStatus(Long taskId, Long statusId) {
        StatusReponseDto statusReponseDto = statusService.getById(statusId);
        TaskResponseDto taskResponseDto = taskService.getById(taskId);
        taskResponseDto.setStatusResponseDto(statusReponseDto);
        return taskResponseDto;
    }
    @Transactional
    @Override
    public TaskResponseDto setRelease(Long taskId, Long releaseId) {
        ReleaseResponseDto releaseResponseDto = releaseService.getById(releaseId);
        TaskResponseDto taskResponseDto = taskService.getById(taskId);
        taskResponseDto.setReleaseResponseDto(releaseResponseDto);
        return taskResponseDto;
    }
    @Transactional   
    @Override
    public TaskResponseDto setTaskType(Long taskId, Long taskTypeId) {
        TaskTypeResponseDto taskTypeResponseDto = taskTypeService.getById(taskTypeId);
        TaskResponseDto taskResponseDto = taskService.getById(taskId);
        taskResponseDto.setTaskTypeResponseDto(taskTypeResponseDto);
        return taskResponseDto;
    }
}
