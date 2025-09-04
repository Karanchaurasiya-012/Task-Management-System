package com.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.entity.SyncQueue;

import java.util.List;
import java.util.UUID;

public interface SyncQueueRepository extends JpaRepository<SyncQueue, UUID> {
    List<SyncQueue> findBySyncStatus(String syncStatus);
}
