package com.example.demo1.controller.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KKafkaListener {

    @KafkaListener(topics = "demo",groupId = "kaf_id")
    public void kafkaL(ConsumerRecord<String,String> massage)
    {
        System.out.println("kafka massage = [" + massage.key() + ": " + massage.value() + "]");
    }
}
