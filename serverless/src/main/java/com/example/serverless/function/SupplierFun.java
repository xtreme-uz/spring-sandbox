package com.example.serverless.function;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Author: Rustambekov Avazbek
 * Date: 02/07/2020
 * Time: 17:40
 */

@Component
public class SupplierFun implements Supplier<Flux<String>> {

    @Override
    public Flux<String> get() {
        String v1 = "<Supplier function: " + System.nanoTime() + ">";
        String v2 = "<Supplier function: " + System.nanoTime() + ">";
        String v3 = "<Supplier function: " + System.nanoTime() + ">";
        String v4 = "<Supplier function: " + System.nanoTime() + ">";
        return Flux.just(v1, v2, v3, v4);
    }
}
