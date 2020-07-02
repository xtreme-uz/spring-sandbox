package com.example.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class ServerlessApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ServerlessApplication.class, args);
		FunctionCatalog catalog = context.getBean(FunctionCatalog.class);
		Function<String, String> function = catalog.lookup("echo");
		System.out.println(function.apply("hello world"));
	}

	@Bean
	public Function<String, String> echo() {
		return s -> "System: " + s;
	}

}
