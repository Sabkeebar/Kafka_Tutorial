package Messagingtutorial.springbootKafkatutorial.kafka;

import Messagingtutorial.springbootKafkatutorial.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer2 {
    @Value("${spring.kafka.topicName2}")
    private  String topicName;
    private  final static Logger LOGGER = LoggerFactory.getLogger(Consumer1.class);
    @KafkaListener(topics = {"topicName"},groupId = "myGroup1")
    public void receive (@Payload String user){ // the message sent Message<User> , so I have to receive as String
        String str ="received message : " + user;
        LOGGER.info(str);
        System.out.println(str);
    }
}
