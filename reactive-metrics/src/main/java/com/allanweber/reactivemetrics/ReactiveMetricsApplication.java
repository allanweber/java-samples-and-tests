package com.allanweber.reactivemetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Hooks;

@SpringBootApplication
public class ReactiveMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMetricsApplication.class, args);
		Hooks.onOperatorDebug();
	}

}
