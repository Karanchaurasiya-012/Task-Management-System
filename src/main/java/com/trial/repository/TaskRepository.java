package com.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByDeletedFalse();
}

