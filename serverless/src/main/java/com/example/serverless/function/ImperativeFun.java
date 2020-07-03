package com.example.serverless.function;

import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Author: Rustambekov Avazbek
 * Date: 02/07/2020
 * Time: 16:44
 */

@Component
public class ImperativeFun implements Function<String, String> {

    @Override
    public String apply(String s) {
        return "<Imperative echo function: " + s + ">";
    }
}
