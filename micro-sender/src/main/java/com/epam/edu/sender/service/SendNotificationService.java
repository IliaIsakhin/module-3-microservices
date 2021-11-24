package com.epam.edu.sender.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationService {
    
    private final RabbitTemplate rabbitTemplate;

    public SendNotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendNotification(String message) {
        rabbitTemplate.convertAndSend("rabbitmq", message);
    }
}
