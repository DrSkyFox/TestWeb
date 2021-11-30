package ru.test.service;

import ru.test.dao.RequestDAO;
import ru.test.dao.ResponseDAO;


public interface SomeService {
    ResponseDAO save(RequestDAO requestMessage);
    ResponseDAO getResponseMsg(Long id);
    RequestDAO getRequestMsg(Long id);
}
