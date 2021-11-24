package ru.test.models;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestResponseMessage {

    private String messageResponse;
    private Long responseID;


}
