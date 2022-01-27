package ru.test.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RabbitMessage {

    private Long id;
    private String message;
    private Integer someValue;

}
