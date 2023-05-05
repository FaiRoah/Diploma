package com.fairoah.diploma_stuff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailHandler {

	@Bean
	public CommandLineRunner MyEmailHandler() {
		return (args) ->{
//			System.out.println("Sending an email to ...");
		};
	}
}
