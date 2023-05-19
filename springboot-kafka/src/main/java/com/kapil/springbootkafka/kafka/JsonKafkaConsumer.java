package com.kapil.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kapil.springbootkafka.payload.User;

@Service
public class JsonKafkaConsumer {
    @Value("${spring.kafka.topic.json.name}")
    private String topicJson;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
        LOGGER.info(String.format("Json Message received --> %s", user.toString()));
    }
}
