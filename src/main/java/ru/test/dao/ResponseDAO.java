package ru.test.dao;


import lombok.*;
import ru.test.models.RequestMessage;
import ru.test.models.RequestResponseMessage;

import javax.persistence.*;

@Builder
@Setter
@Getter

@ToString
public class ResponseDAO {


    private Long id;

    private String messageResponse;

    private Boolean isEnabled;


    public ResponseDAO(RequestResponseMessage response) {
        this.id = response.getId();
        this.messageResponse = response.getMessageResponse();
        this.isEnabled = response.getIsEnabled();
    }


    public ResponseDAO(Long id, String messageResponse, Boolean isEnabled) {
        this.id = id;
        this.messageResponse = messageResponse;
        this.isEnabled = isEnabled;
    }

    public ResponseDAO() {
    }
}
