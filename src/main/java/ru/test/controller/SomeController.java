package ru.test.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.dao.RequestDAO;
import ru.test.dao.ResponseDAO;
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
    public ResponseEntity<ResponseDAO> createMessage(@Parameter(description = "Message body") @RequestBody RequestDAO messageDAO) {
        log.info("Create message. MessageBody is {}", messageDAO);
        var response = service.save(messageDAO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/req={id}", produces = "application/json")
    public RequestDAO getRequestMsg(@Parameter(description = "Get Message with Id") @PathVariable("id") Long id) {
        log.info("Get Message with ID: {}", id);
        return service.getRequestMsg(id);
    }

    @GetMapping(path = "/resp={id}", produces = "application/json")
    public ResponseDAO getRequestResponseMsg(@Parameter(description = "Get Message with Id") @PathVariable("id") Long id) {
        log.info("Get Message with ID: {}", id);
        return service.getResponseMsg(id);
    }


}
