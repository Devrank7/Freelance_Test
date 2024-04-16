package com.example.demo.controller.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Consume {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMassage(String msg) {
        int i = msg.length();

        kafkaTemplate.send("demo","name",msg);
    }
}
