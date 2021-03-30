package com.example.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    private final CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        logger.info("message: {}", message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }

}
