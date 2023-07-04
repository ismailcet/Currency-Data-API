package com.ismailcet.currencyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencyDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyDataApiApplication.class, args);
	}

}
