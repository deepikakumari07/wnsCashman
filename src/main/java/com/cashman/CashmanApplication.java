package com.cashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CashmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashmanApplication.class, args);
	}
}
