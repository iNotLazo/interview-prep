package com.lazo.confizprep.taskapi.service;

import com.lazo.confizprep.taskapi.dto.CreateTaskRequest;
import com.lazo.confizprep.taskapi.dto.UpdateTaskRequest;
import com.lazo.confizprep.taskapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public TaskService() {
        tasks.add(
                new Task(
                        "Learn Big O",
                        true
                )
        );

        tasks.add(
                new Task(
                        "Learn Streams",
                        true
                )
        );

        tasks.add(
                new Task(
                        "Learn Spring Boot",
                        false
                )
        );
    }

    public List<Task> findAll() {
        return List.copyOf(tasks);
    }

    public Task create(CreateTaskRequest request) {
        Task task = new Task(
                request.title(),
                false
        );

        tasks.add(task);

        return task;
    }

    public Optional<Task> update(long id, UpdateTaskRequest request) {

        Optional<Task> taskOptional = getById(id);

        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }

        Task task = taskOptional.get();

        Task updatedTask = new Task(
                task.getTitle(),
                request.completed()
        );

        int index = tasks.indexOf(task);

        tasks.set(index, updatedTask);

        return Optional.of(updatedTask);
    }

    public boolean delete(Long id) {
        Optional<Task> task = getById(id);

        if (task.isEmpty()) {
            return false;
        }

        return tasks.remove(task.get());
    }

    public Optional<Task> getByTitle(String title) {
        return tasks.stream()
                .filter(task -> task.getTitle().equals(title))
                .findFirst();
    }

    public Optional<Task> getById(long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }
}