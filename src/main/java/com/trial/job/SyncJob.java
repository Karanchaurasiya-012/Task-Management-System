package com.trial.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.trial.entity.SyncQueue;
import com.trial.service.SyncQueueService;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SyncJob {

    private final SyncQueueService syncQueueService;

    @Scheduled(fixedRate = 30000)
public void processSyncQueue() {
    log.info("Sync job started...");

    List<SyncQueue> pendingTasks = syncQueueService.getPendingSyncs();

    if (pendingTasks.isEmpty()) {
        log.info(" No pending tasks to sync.");
        return;
    }

    for (SyncQueue item : pendingTasks) {
        try {
            log.info("Attempting to sync taskId={} operationType={} retryCount={}",
                    item.getTaskId(), item.getOperationType(), item.getRetryCount());

            if (Math.random() < 0.3) { 
                throw new RuntimeException("Simulated API failure");
            }

            syncQueueService.markAsSynced(item.getId());
            log.info("Successfully synced taskId={}", item.getTaskId());

        } catch (Exception e) {
            log.error("Sync failed for taskId={} error={}", item.getTaskId(), e.getMessage());
            syncQueueService.markAsFailed(item.getId(), e.getMessage());
        }
    }
}

}
