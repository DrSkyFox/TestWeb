package ru.test.service;

import com.rabbitmq.client.AMQP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.models.RabbitMessage;

@Slf4j
@Service
public class MessageBroker implements IMessage{

    private final RabbitTemplate rabbit;



    @Autowired
    public MessageBroker(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void send(RabbitMessage message) {
        log.info("Call send message to broker. Object {}", message);
        rabbit.convertAndSend("service.test",message);
        log.info("Exit from method 'send message to broker' ");
    }



}
