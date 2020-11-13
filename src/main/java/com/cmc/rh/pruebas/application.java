package com.cmc.rh.pruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cmc.rh.jwt.Autentication;

@SpringBootApplication
@ComponentScan
public class application {
	
	  public static void main(String[] args) {
	        SpringApplication.run(application.class, args);
	    }
	
	  @Bean
	  public Autentication autentication() {
		  return new Autentication();
	  }
	  
}
