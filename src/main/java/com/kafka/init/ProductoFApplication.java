package com.kafka.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.kafka.controller","com.kafka.service"})
public class ProductoFApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoFApplication.class, args);
	}

}
