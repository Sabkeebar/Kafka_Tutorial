package Messagingtutorial.springbootKafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer1 {
    private  final static Logger LOGGER = LoggerFactory.getLogger(Consumer1.class);
    @Value("${spring.kafka.topicName1}")
    private  String topicName;
   @KafkaListener(topics = {"topicName"},groupId = "myGroup1")
    public void receive (@Payload String message){
        String str ="received message : " + message;
       LOGGER.info(str);
       System.out.println(str);
   }
}
