package com.example.serverless.function;

import org.springframework.cloud.function.context.PollableBean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Function;

import static java.lang.String.valueOf;

/**
 * Author: Rustambekov Avazbek
 * Date: 02/07/2020
 * Time: 16:43
 */

@Component
public class ReactiveFun implements Function<Flux<String>, Flux<String>> {

    @Override
    public Flux<String> apply(Flux<String> stringFlux) {
        return stringFlux.map(s -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            return "<Reactive echo function: " + s + ">";
        });
    }


}
