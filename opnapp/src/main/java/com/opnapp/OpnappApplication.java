package com.opnapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpnappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpnappApplication.class, args);
		System.out.println(
				  "+---------------------------------------+\n"
				+ "| ____ _____  __  _   ____  _____ _____ |\n"
				+ "|/ () \\| ()_)|  \\| | / () \\ | ()_)| ()_)|\n"
				+ "|\\____/|_|   |_|\\__|/__/\\__\\|_|   |_|   |\n"
				+ "+---------------------------------------+");
	}
}
