package Messagingtutorial.springbootKafkatutorial.controller;

import Messagingtutorial.springbootKafkatutorial.kafka.Producer1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {
    @Autowired
    private Producer1 producer1;
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
        System.out.println("here");
        producer1.sendMessage(message);
      return ResponseEntity.ok("Message have sent to topic");
    }

}
