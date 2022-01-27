package ru.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.management.Query;


@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "custom")
public class ConfigProperties {

    private Long size;

    private String msg;





}
