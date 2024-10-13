package com.vitorsanches.mochi;

import org.springframework.boot.SpringApplication;

public class TestMochiApplication {

	public static void main(String[] args) {
		SpringApplication.from(MochiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
