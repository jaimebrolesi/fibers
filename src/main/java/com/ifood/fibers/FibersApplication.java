package com.ifood.fibers;

import co.paralleluniverse.springframework.boot.autoconfigure.web.FiberSpringBootApplication;
import org.springframework.boot.SpringApplication;

@FiberSpringBootApplication
public class FibersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibersApplication.class, args);
	}
}
