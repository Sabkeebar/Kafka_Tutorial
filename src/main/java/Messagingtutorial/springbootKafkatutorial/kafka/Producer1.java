package Messagingtutorial.springbootKafkatutorial.kafka;

import Messagingtutorial.springbootKafkatutorial.domain.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Producer1 {
    private  static final Logger LOGGER = LoggerFactory.getLogger(Producer1.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${spring.kafka.topicName1}")
    private  String topicName;

    public void sendMessage(String message){

        LOGGER.info(String.format("message sent %s ", message));
        kafkaTemplate.send("topicName",message);
    }


}
