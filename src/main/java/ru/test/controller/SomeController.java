package ru.test.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;
import ru.test.service.SomeService;

@Slf4j
@Tag(name = "Message resource API", description = "API allows you to manipulate data Message resources")
@RestController
@RequestMapping("/api/v1/message")
public class SomeController {

    private final SomeService service;

    @Autowired
    public SomeController(SomeService service) {
        this.service = service;
    }

    @Operation(summary = "Create new Message")
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RequestResponseMessage> createMessage(@Parameter(description = "Message body") @RequestBody RequestMessage messageDAO) {
        log.info("Create message. MessageBody is {}", messageDAO);
        return new ResponseEntity<>(service.save(messageDAO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public RequestMessage getRequestMsg(@Parameter(description = "Get Message with Id") @PathVariable("id") Long id) {
        log.info("Get Message with ID: {}", id);
        return service.getRequestMsg(id);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public RequestResponseMessage getRequestResponseMsg(@Parameter(description = "Get Message with Id") @PathVariable("id") Long id) {
        log.info("Get Message with ID: {}", id);
        return service.getResponseMsg(id);
    }


}
