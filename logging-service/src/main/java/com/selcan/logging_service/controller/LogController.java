package com.selcan.logging_service.controller;

import com.selcan.logging_service.dto.LogRequest;
import com.selcan.logging_service.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public void log(@RequestBody LogRequest request) {
        logService.saveLog(request);
    }
}
