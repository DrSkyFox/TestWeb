package ru.test.models;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestMessage {


    private Long idRequest;
    private String msg;


}
