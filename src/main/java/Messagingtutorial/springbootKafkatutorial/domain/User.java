package Messagingtutorial.springbootKafkatutorial.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class User {
    private  int id;
    private  String firstName;
    private  String lastName;
}
