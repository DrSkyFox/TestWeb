package ru.test.dao;

import lombok.*;
import ru.test.models.RequestMessage;


@Builder
@Setter
@Getter
@ToString
public class RequestDAO {


    private Long id;

    private String msg;

    private Boolean isEnabled;


    public RequestDAO(RequestMessage request) {
        this.id = request.getId();
        this.msg = request.getMsg();
        this.isEnabled = request.getIsEnabled();
    }

    public RequestDAO(Long id, String msg, Boolean isEnabled) {
        this.id = id;
        this.msg = msg;
        this.isEnabled = isEnabled;
    }

    public RequestDAO() {
    }
}
