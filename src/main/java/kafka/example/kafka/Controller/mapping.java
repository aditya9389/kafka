package kafka.example.kafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class mapping {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final String TOPIC = "Golden_Record";

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        kafkaTemplate.send(TOPIC, message);
        return ResponseEntity.ok("Message sent to Kafka!");
    }
}
