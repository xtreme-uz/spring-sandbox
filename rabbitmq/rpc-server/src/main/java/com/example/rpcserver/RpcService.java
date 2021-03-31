package com.example.rpcserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RpcService {

    @RabbitListener(queues = "rpc-exchange.requests")
    public int fibonacci(int n) {
        log.info(" [x] Received request for {}", n);
        int result = fib(n);
        log.info(" [.] Returned {}", result);
        return result;
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        else
            return n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }

}
