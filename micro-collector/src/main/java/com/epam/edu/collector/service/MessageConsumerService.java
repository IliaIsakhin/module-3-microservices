package com.epam.edu.collector.service;

import com.epam.edu.collector.config.MicroRecipientClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MessageConsumerService {
    
    private static final Logger log = LoggerFactory.getLogger(MessageConsumerService.class);
    
    private final MicroRecipientClient client;

    public MessageConsumerService(MicroRecipientClient client) {
        this.client = client;
    }

    @Scheduled(cron = "0/3 * * ? * *")
    public void fetchMessages() {
        log.info("Trying to fetch messages...");
        
        var messages = client.fetchMessages();
        if (!messages.isEmpty()) {
            log.info("Fetched messages: {}", Arrays.toString(messages.toArray()));
        }
    }
}
