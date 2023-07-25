package com.fivvy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FivvyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FivvyApplication.class, args);
	}

}
