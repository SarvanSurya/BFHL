package com.bfhc.jfsd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BfhlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BfhlApplication.class, args);
		System.out.println("Working for JAR FILE !");
	}

}
