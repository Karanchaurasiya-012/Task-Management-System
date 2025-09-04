package com.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrialApplication.class, args);
	}

}
