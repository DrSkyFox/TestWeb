package ru.test.service;

import ru.test.models.RabbitMessage;

public interface IMessage {

    void send(RabbitMessage message);
}
