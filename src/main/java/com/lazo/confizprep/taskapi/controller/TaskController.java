package com.lazo.confizprep.taskapi.controller;

import com.lazo.confizprep.taskapi.dto.CreateTaskRequest;
import com.lazo.confizprep.taskapi.dto.UpdateTaskRequest;
import com.lazo.confizprep.taskapi.model.Task;
import com.lazo.confizprep.taskapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        Optional<Task> task = service.getById(id);

        if (task.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task.get());
    }

    @PostMapping
    public ResponseEntity<Task> create(
            @RequestBody CreateTaskRequest request
    ) {
        Task task = service.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(
            @PathVariable Long id,
            @RequestBody UpdateTaskRequest request
    ) {

        Optional<Task> updatedTask = service.update(id, request);

        if (updatedTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boolean deleted = service.delete(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}