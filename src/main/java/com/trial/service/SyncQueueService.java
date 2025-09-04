package com.trial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.trial.entity.SyncQueue;
import com.trial.repository.SyncQueueRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SyncQueueService {

    private final SyncQueueRepository syncQueueRepository;

    public SyncQueue addToQueue(UUID taskId, String operationType) {
        SyncQueue queueItem = SyncQueue.builder()
                .taskId(taskId)
                .operationType(operationType)
                .syncStatus("PENDING")
                .retryCount(0)
                .build();

        return syncQueueRepository.save(queueItem);
    }

    public List<SyncQueue> getPendingSyncs() {
        return syncQueueRepository.findBySyncStatus("PENDING");
    }

    public void markAsSynced(UUID id) {
        syncQueueRepository.findById(id).ifPresent(item -> {
            item.setSyncStatus("SUCCESS");
            syncQueueRepository.save(item);
        });
    }

    public void markAsFailed(UUID id, String errorMessage) {
    syncQueueRepository.findById(id).ifPresent(item -> {
        int maxRetries = 3;
        item.setRetryCount(item.getRetryCount() + 1);
        item.setErrorMessage(errorMessage);

        if (item.getRetryCount() >= maxRetries) {
            item.setSyncStatus("PERMANENT_FAILED");
        } else {
            item.setSyncStatus("FAILED");
        }

        syncQueueRepository.save(item);
    });
}

}
