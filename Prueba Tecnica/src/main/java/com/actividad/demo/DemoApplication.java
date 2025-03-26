package com.actividad.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
@EnableCaching
public class DemoApplication {
	//http://localhost:8080/api/naves

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
