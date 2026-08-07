package com.lazo.confizprep.taskapi.repository;

import com.lazo.confizprep.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}