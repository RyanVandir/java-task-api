package com.ryan.task_api.service;

import com.ryan.task_api.dto.TaskResponse;
import com.ryan.task_api.model.Task;
import com.ryan.task_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Page<Task> getTasks(int page, int size, String sortBy, String direction) {
        //setindo de ordenação
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        //Cria obj pageable
        Pageable pageable = PageRequest.of(page, size, sort);
        //retorna pag com dados + metadados
        return taskRepository.findAll(pageable);
    }

    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task patchById(Integer id, TaskResponse response) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (response.title() != null) {
            task.setTitle(response.title());
        }
        if (response.description() != null) {
            task.setDescription(response.description());
        }
        return taskRepository.save(task);
    }
}
