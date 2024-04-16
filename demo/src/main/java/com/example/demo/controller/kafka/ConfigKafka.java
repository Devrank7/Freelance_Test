package com.example.demo.controller.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigKafka {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("demo", 1, (short) 1);
    }
}
