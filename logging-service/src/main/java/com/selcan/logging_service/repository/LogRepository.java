package com.selcan.logging_service.repository;

import com.selcan.logging_service.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntry, Long> {
}
