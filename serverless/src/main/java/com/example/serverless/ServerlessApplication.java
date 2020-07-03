package com.example.serverless;

import com.example.serverless.function.ImperativeFun;
import com.example.serverless.function.ReactiveFun;
import com.example.serverless.function.SupplierFun;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.ConfigurableApplicationContext;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class ServerlessApplication {

	public static void main(String[] args) {
		Function<String, String> function = new ImperativeFun();
		System.out.println(function.apply("hello world"));

		Function<Flux<String>, Flux<String>> rFunction = new ReactiveFun();
		rFunction.apply(Flux.just("Test1", "Test2", "Test3", "Test4")).subscribe(System.out::println);

		Supplier<Flux<String>> supplier = new SupplierFun();
		supplier.get().subscribe(System.out::println);

	}

}
