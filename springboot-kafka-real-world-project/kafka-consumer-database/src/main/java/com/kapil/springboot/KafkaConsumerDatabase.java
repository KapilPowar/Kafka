package com.kapil.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kapil.springboot.entity.Wikimedia;
import com.kapil.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaConsumerDatabase {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    private WikimediaDataRepository  dataRepository;

    public KafkaConsumerDatabase(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener( topics =  "${spring.kafka.topic.name}", 
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event Message received --> %s ", eventMessage ));
         Wikimedia wikimedia = new Wikimedia();
         wikimedia.setWikiEventData(eventMessage);

        dataRepository.save(wikimedia);
        
    }
}
