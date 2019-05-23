package com.accenture.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.accenture"})
public class CamelPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelPocApplication.class, args);
	}

}
