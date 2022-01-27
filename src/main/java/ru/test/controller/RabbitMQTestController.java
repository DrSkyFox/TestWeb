package ru.test.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.jparepo.RabbitMQMessageRepo;
import ru.test.models.RabbitMessage;
import ru.test.models.ReceiveMessageList;
import ru.test.service.IMessage;

import java.util.Date;

@Slf4j
@Tag(name = "Message resource API", description = "API allows you to manipulate data Message resources")
@RestController
@RequestMapping("/api/v1/broker")
public class RabbitMQTestController {

    private final RabbitMQMessageRepo repo;
    private final IMessage service;


    @Autowired
    public RabbitMQTestController(RabbitMQMessageRepo repo, IMessage service) {
        this.repo = repo;
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity sendMessageToBroker(@RequestBody RabbitMessage message) {
        log.info("Send message to broker: {}", message);
        service.send(message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<ReceiveMessageList> getAllReceiveMessageList() {
        log.info("Get All messages from broker");
        return ResponseEntity.status(HttpStatus.OK).body(
                ReceiveMessageList.builder()
                        .date(new Date())
                        .messageList(repo.getAll())
                        .build()
        );
    }


}
