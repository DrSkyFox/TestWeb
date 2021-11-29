package ru.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.test.jparepo.RequestMessageRepository;
import ru.test.jparepo.RequestMessageResponseRepository;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;
import ru.test.repo.InMemoryRepository;

@Service
public class SomeServiceImpl implements SomeService{

    @Value("${custom.msg}")
    private static String msg;

    private final RequestMessageRepository request;
    private final RequestMessageResponseRepository response;

    @Autowired
    public SomeServiceImpl(RequestMessageRepository request, RequestMessageResponseRepository response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public RequestResponseMessage save(RequestMessage requestMessage) {
        var savedDB = request.save(requestMessage);
        var saveResponse =  response.save(RequestResponseMessage.builder()
                        .messageResponse(msg + " Do u know about u-self ? Dont ask me about " + savedDB.getMsg() + "!!!")
                        .request(savedDB)
                .build());
        return saveResponse;
    }

    @Override
    public RequestResponseMessage getResponseMsg(Long id) {
        var responseMsg = response.findById(id);
        if(responseMsg.isPresent()) {
            return responseMsg.get();
        } else throw new RuntimeException("MsgNotFound");
    }

    @Override
    public RequestMessage getRequestMsg(Long id) {
        var requestMsg = request.findById(id);
        if(requestMsg.isPresent()) {
            return requestMsg.get();
        } else throw new RuntimeException("MsgNotFound");

    }
}
