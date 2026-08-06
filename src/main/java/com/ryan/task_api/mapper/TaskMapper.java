package com.ryan.task_api.mapper;

import com.ryan.task_api.dto.TaskResponse;
import com.ryan.task_api.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    // ENTITY -> RESPONSE
    TaskResponse toResponse(Task task);
    List<TaskResponse> toResponse(List<Task> tasks);
}
