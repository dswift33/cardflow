package com.davidswift.cardflow;

import org.springframework.boot.SpringApplication;

public class TestCardflowApplication {

	public static void main(String[] args) {
		SpringApplication.from(CardflowApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
