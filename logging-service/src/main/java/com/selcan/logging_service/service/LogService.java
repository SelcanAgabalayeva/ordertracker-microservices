package com.selcan.logging_service.service;

import com.selcan.logging_service.dto.LogRequest;

public interface LogService {
    void saveLog(LogRequest request);
}
