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
@Table(name ="request_response")
public class RequestResponseMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "response")
    private String messageResponse;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    private RequestMessage request;


}
