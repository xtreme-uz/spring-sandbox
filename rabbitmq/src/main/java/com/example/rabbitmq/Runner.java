package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate template;
    private final Receiver receiver;

    public Runner(RabbitTemplate template, Receiver receiver) {
        this.template = template;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        template.convertAndSend(RabbitmqApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "hello from mq");
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
