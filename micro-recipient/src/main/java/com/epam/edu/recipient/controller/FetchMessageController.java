package com.epam.edu.recipient.controller;

import com.epam.edu.recipient.service.NotificationReceiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchMessageController {
    
    private final NotificationReceiveService service;

    public FetchMessageController(NotificationReceiveService service) {
        this.service = service;
    }

    @GetMapping("/messages")
    public List<String> fetchMessages() {
        return service.evictMessages();
    }
}
