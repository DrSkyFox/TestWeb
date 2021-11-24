package ru.test.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.test.models.HashMapSized;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;


import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRepository {

    @Value("${spring.size.repo:100}")
    private Integer size;

    @Value("${spring.response.msg:'Hello, Mr. Unknown !'}")
    private String responseMessage;

    private static AtomicLong atomicLong = new AtomicLong(0);

    private Map<Long, RequestMessage> mapOfRequest;
    private Map<Long , RequestResponseMessage> mapOfResponse;


    public InMemoryRepository() {
        this.mapOfRequest = new HashMapSized<>(size);
        this.mapOfResponse = new HashMapSized<>(size);
    }

    public RequestResponseMessage save(RequestMessage request) {
        var id = atomicLong.getAndIncrement();
        mapOfRequest.put(id, request);
        return RequestResponseMessage.builder()
                .messageResponse(responseMessage + ": Do u know about yourself ? And never request me about: " + request.getMsg() + "!!!")
                .responseID(id)
                .build();
    }

    public RequestResponseMessage getResponseMsg(Long id) {
        return mapOfResponse.get(id);
    }

    public RequestMessage getRequest(Long id) {
        return mapOfRequest.get(id);
    }


}

