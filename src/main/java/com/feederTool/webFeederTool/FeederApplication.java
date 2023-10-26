package com.feederTool.webFeederTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FeederApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeederApplication.class, args);
	}





}
