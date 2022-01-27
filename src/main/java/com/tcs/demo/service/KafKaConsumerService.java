package com.tcs.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 
@Service
public class KafKaConsumerService 
{
    private final Logger logger = 
            LoggerFactory.getLogger(KafKaConsumerService.class);
    private List<String> consumer=new ArrayList<>();
 
    @KafkaListener(topics = "tcs_topic", 
            groupId = "GROUP_ID")
    public void consume(String message) 
    {
        logger.info(String.format("Message recieved -> %s", message));
        consumer.add(message);
    }
    
    public List<String> consume() 
    {
        return consumer;
    }
}