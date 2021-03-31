package com.example.rabbitmqproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@Component
public class DataProducer implements CommandLineRunner {

    @Value("${amqp.queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;
    private final List<String> resources = new ArrayList<>();

    public DataProducer(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {
        this.context = context;
        this.rabbitTemplate = rabbitTemplate;
        resources.addAll(asList(
                "{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\"}",
                "{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\"}",
                "{\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\",\"last_name\":\"Wong\"}",
                "{\"id\":4,\"email\":\"eve.holt@reqres.in\",\"first_name\":\"Eve\",\"last_name\":\"Holt\"}"
        ));
    }

    @Override
    public void run(String... args) throws Exception {
        for (String resource : resources) {
            Thread.sleep(2000);
            log.info("produced: {}", resource);
            rabbitTemplate.convertAndSend(queueName, resource);
        }
        context.close();
    }
}