package com.ryan.task_api.controller;

import com.ryan.task_api.model.Task;
import com.ryan.task_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @PostMapping
    public Task save(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
}
