package ru.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.test.jparepo.RabbitMQMessageRepo;
import ru.test.models.RabbitMessage;

@Slf4j
@Component
public class RabbitMQReceiver {

    private final RabbitMQMessageRepo repo;

    @Autowired
    public RabbitMQReceiver(RabbitMQMessageRepo repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = "service.test")
    public void onMessage(RabbitMessage message) {
        log.info("Get Message from broker - {}", message);
        repo.save(message);
    }


}
