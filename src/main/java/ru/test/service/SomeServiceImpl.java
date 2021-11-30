package ru.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.dao.RequestDAO;
import ru.test.dao.ResponseDAO;
import ru.test.jparepo.RequestMessageRepository;
import ru.test.jparepo.RequestMessageResponseRepository;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;


@Slf4j
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
    @Transactional
    public ResponseDAO save(RequestDAO requestMessage) {
        log.info("Saved to bd {}", requestMessage.toString());
        var savedDB = request.save(RequestMessage.builder()
                        .msg(requestMessage.getMsg())
                        .isEnabled(true)
                .build());
        log.info(savedDB.toString());
        var saveResponse =  response.save(RequestResponseMessage.builder()
                        .messageResponse(msg + " Do u know about u-self ? Dont ask me about " + savedDB.getMsg() + "!!!")
                        .request(savedDB)
                .build());
        log.info(saveResponse.toString());
        return new ResponseDAO(saveResponse);
    }

    @Override
    public ResponseDAO getResponseMsg(Long id) {
        var responseMsg = response.findById(id);
        if(responseMsg.isPresent()) {
            return new ResponseDAO(responseMsg.get());
        } else throw new RuntimeException("MsgNotFound");
    }

    @Override
    public RequestDAO getRequestMsg(Long id) {
        var requestMsg = request.findById(id);
        if(requestMsg.isPresent()) {
            return new RequestDAO(requestMsg.get());
        } else throw new RuntimeException("MsgNotFound");

    }
}
