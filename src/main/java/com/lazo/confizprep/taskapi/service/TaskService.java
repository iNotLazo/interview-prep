package com.lazo.confizprep.taskapi.service;

import com.lazo.confizprep.taskapi.dto.CreateTaskRequest;
import com.lazo.confizprep.taskapi.dto.UpdateTaskRequest;
import com.lazo.confizprep.taskapi.model.Task;
import com.lazo.confizprep.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task create(CreateTaskRequest request) {

        Task task = new Task(
                request.title(),
                false
        );

        return repository.save(task);
    }

    public Optional<Task> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Task> update(Long id, UpdateTaskRequest request) {

        Optional<Task> taskOptional = repository.findById(id);

        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }

        Task task = taskOptional.get();

        task.setTitle(request.title());
        task.setCompleted(request.completed());

        Task updatedTask = repository.save(task);

        return Optional.of(updatedTask);
    }

    public boolean delete(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}