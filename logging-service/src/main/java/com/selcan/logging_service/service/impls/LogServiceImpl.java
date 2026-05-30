package com.selcan.logging_service.service.impls;

import com.selcan.logging_service.dto.LogRequest;
import com.selcan.logging_service.model.LogEntry;
import com.selcan.logging_service.repository.LogRepository;
import com.selcan.logging_service.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public void saveLog(LogRequest request) {

        LogEntry log = new LogEntry();
        log.setServiceName(request.getServiceName());
        log.setEventType(request.getEventType());
        log.setLevel(request.getLevel());
        log.setMessage(request.getMessage());
        log.setTimestamp(LocalDateTime.now());

        logRepository.save(log);
    }
}
