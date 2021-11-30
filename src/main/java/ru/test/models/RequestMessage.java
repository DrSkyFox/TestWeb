package ru.test.models;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "request_message")
public class RequestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msg", nullable = false)
    private String msg;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    private RequestResponseMessage response;


}
