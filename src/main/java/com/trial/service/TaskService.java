package com.trial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.trial.entity.Task;
import com.trial.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final SyncQueueService syncQueueService;

    public Task createTask(Task task) {
        Task saved = taskRepository.save(task);
        syncQueueService.addToQueue(saved.getId(), "CREATE");
        return saved;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findByDeletedFalse();
    }

    public Optional<Task> getTask(UUID id) {
        return taskRepository.findById(id).filter(t -> !t.isDeleted());
    }


    public Optional<Task> updateTask(UUID id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            task.setSyncStatus("PENDING");

            Task saved = taskRepository.save(task);
            syncQueueService.addToQueue(saved.getId(), "UPDATE");
            return saved;
        });
    }


    public boolean deleteTask(UUID id) {
        return taskRepository.findById(id).map(task -> {
            task.setDeleted(true);
            task.setSyncStatus("PENDING");

            Task saved = taskRepository.save(task);
            syncQueueService.addToQueue(saved.getId(), "DELETE");
            return true;
        }).orElse(false);
    }
}
