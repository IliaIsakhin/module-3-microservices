package com.epam.edu.collector.config;

import feign.Feign;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {
    
    @Value("${feign.recipient.host}")
    private String recipientHost;

    @Value("${feign.recipient.port}")
    private String recipientPort;
    
    @Bean
    public Decoder jacksonDecoder() {
        return new JacksonDecoder();
    }
    
    @Bean
    public MicroRecipientClient microRecipientClient(Decoder jacksonDecoder) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(jacksonDecoder)
                .target(MicroRecipientClient.class, String.format("http://%s:%s", recipientHost, recipientPort));
    }
}
