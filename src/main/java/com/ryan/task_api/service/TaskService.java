package com.ryan.task_api.service;

import com.ryan.task_api.model.Task;
import com.ryan.task_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public void deleteById(Integer id){
         taskRepository.deleteById(id);
    }
}
