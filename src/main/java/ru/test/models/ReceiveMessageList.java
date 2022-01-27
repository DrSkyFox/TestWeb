package ru.test.models;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceiveMessageList {

    private Date date;
    private List<RabbitMessage> messageList;
}
