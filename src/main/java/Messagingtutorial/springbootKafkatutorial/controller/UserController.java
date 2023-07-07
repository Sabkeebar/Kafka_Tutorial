package Messagingtutorial.springbootKafkatutorial.controller;

import Messagingtutorial.springbootKafkatutorial.domain.User;
import Messagingtutorial.springbootKafkatutorial.kafka.Producer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/kafka")
@RestController
public class UserController {
    @Autowired
   private Producer2 producer2;
    @PostMapping("/user")
    public ResponseEntity<String> publish(@RequestBody User user){

        producer2.sendUser(user);
        return ResponseEntity.ok("Message have sent to topic");
    }
}
