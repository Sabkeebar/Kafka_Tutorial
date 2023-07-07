package Messagingtutorial.springbootKafkatutorial.kafka;

import Messagingtutorial.springbootKafkatutorial.domain.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
@Service
public class Producer2 {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value("${spring.kafka.topicName2}")
    private  String topicName;
private  static final  Logger LOGGER = LoggerFactory.getLogger(Producer2.class);

    public void sendUser(User user){


        LOGGER.info(String.format("message sent %s ", user));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "topicName")
                .build();
        System.out.println(message);
        kafkaTemplate.send(message);
    }


}
