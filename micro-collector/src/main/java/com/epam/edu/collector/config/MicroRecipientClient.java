package com.epam.edu.collector.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("recipient")
public interface MicroRecipientClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/messages")
    List<String> fetchMessages();
}
