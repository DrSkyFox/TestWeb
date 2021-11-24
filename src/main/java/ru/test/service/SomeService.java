package ru.test.service;

import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;

public interface SomeService {
    RequestResponseMessage save(RequestMessage requestMessage);
    RequestResponseMessage getResponseMsg(Long id);
    RequestMessage getRequestMsg(Long id);
}
