package com.rezarvasyon.saha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SahaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahaApplication.class, args);
	}

}
