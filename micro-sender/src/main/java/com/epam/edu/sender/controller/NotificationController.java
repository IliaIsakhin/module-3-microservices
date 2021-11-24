package com.epam.edu.sender.controller;

import com.epam.edu.sender.model.NotificationRequest;
import com.epam.edu.sender.service.SendNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    
    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);  
    
    private final SendNotificationService sendNotificationService;

    public NotificationController(SendNotificationService sendNotificationService) {
        this.sendNotificationService = sendNotificationService;
    }

    @PostMapping("/notification")
    public ResponseEntity<Boolean> sendNotification(@RequestBody NotificationRequest request) {
        log.info("Notification controller received message {} from {}", request.getMessage(), request.getUserName());
        
        sendNotificationService.sendNotification(request.getMessage());
        
        return ResponseEntity.ok().body(true);
    }
}
