package com.trial.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sync_queue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SyncQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID taskId;

    @Column(nullable = false)
    private String operationType; 

    @Column(nullable = false)
    private String syncStatus = "PENDING"; 

    private String errorMessage;

    private int retryCount = 0;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
