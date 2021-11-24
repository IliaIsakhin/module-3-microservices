package com.epam.edu.recipient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NotificationReceiveService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationReceiveService.class);
    private final List<String> messages = Collections.synchronizedList(new ArrayList<>());
    
    private final RabbitTemplate rabbitTemplate;

    public NotificationReceiveService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @Scheduled(cron = "* * * * * *") // every second
    public void readMessage() {
        logger.info("Trying to read message from queue");
        var message = rabbitTemplate.receive();
        
        if (message == null) return;

        String convertedMessage = new String(message.getBody());
        logger.info("Message {} received", convertedMessage);
        messages.add(convertedMessage);
    }
    
    public List<String> evictMessages() {
        var result = new ArrayList<>(messages);
        messages.clear();
        
        return result;
    }
}
