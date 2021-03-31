package com.example.rpcclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RpcClient {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    private int message = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void send() {
        log.info(" [x] Requesting rpc({})", message);
        Object rpc = rabbitTemplate.convertSendAndReceive(directExchange.getName(), "rpc", message++);
        log.info(" [.] Got {}", rpc);
    }

}
