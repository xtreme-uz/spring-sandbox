package com.example.rpcclient;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Config {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("rpc-exchange");
    }

}
