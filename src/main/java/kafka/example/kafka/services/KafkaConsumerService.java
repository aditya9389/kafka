package kafka.example.kafka.services;

import kafka.example.kafka.model.MessageEntity;
import kafka.example.kafka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private MessageRepository messageRepository;


    @KafkaListener(topics = "Golden_Record", groupId = "demo_group")
    public void consume(MessageEntity message) {
        System.out.println("Raw message: " + message);
        messageRepository.save(message);
    }

}
