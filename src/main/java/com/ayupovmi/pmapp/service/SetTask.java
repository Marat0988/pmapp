package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;

public interface SetTask {

    TaskResponseDto setUser (Long taskId, Long userId);
    TaskResponseDto setStatus (Long taskId, Long statusId);
    TaskResponseDto setRelease (Long taskId, Long releaseId);
    TaskResponseDto setTaskType (Long taskId, Long taskTypeId);
}
