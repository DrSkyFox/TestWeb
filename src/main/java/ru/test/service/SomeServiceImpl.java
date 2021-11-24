package ru.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;
import ru.test.repo.InMemoryRepository;

@Service
public class SomeServiceImpl implements SomeService{


    private final InMemoryRepository repository;

    @Autowired
    public SomeServiceImpl(InMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public RequestResponseMessage save(RequestMessage requestMessage) {
        return repository.save(requestMessage);
    }

    @Override
    public RequestResponseMessage getResponseMsg(Long id) {
        return repository.getResponseMsg(id);
    }

    @Override
    public RequestMessage getRequestMsg(Long id) {
        return repository.getRequest(id);
    }
}
