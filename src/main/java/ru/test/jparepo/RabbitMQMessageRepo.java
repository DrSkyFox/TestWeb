package ru.test.jparepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.test.models.RabbitMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Slf4j
@Repository
public class RabbitMQMessageRepo {


    private AtomicLong aLong = new AtomicLong(0);
    private List<RabbitMessage> messageList = Collections.synchronizedList(new ArrayList<>());


    private void insert(RabbitMessage message) {
        log.info("insert new message {}", message);
        if(messageList.size() >= 20) {
            messageList.remove(20);
        }
        messageList.add(message);
    }

    private RabbitMessage getMessage(Integer id)
    {
        log.info("get by id {] message from repo", id);
        return messageList.get(id);
    }



    public List<RabbitMessage> getAll() {
        logMsg("getAll");
        return messageList;
    }

    public void save(RabbitMessage message) {
        logMsg("save");
        insert(message);
    }

    public RabbitMessage getById(Integer id) {
        logMsg("getById");
        return getMessage(id);
    }


    private void logMsg(String call) {
        long id = aLong.incrementAndGet();
        log.info("Operation id - {} {}}", id, call);
    }

}
