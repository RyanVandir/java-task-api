package com.ryan.task_api.controller;

import com.ryan.task_api.dto.TaskResponse;
import com.ryan.task_api.mapper.TaskMapper;
import com.ryan.task_api.model.Task;
import com.ryan.task_api.service.TaskService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;
    private final TaskMapper mapper;

    @PostMapping
    public ResponseEntity<TaskResponse> save(@RequestBody Task task) {
        return ResponseEntity.ok(
                mapper.toResponse(service.create(task))
        );
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(
                mapper.toResponse(
                        service.findAll()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
       return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponse> patchById(@PathVariable Integer id, @RequestBody TaskResponse task) {
        return ResponseEntity.ok(
                mapper.toResponse(
                        service.patchById(id, task)
                )
        );
    }
}
