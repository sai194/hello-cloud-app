package com.sye.microservices.sample;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloCloudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloCloudAppApplication.class, args);
	}
	
	@RestController
	class MessageRestController {
	 
		//http://localhost:5000/hello?name=sai
	    @GetMapping("/hello")
	    String getMessage(@RequestParam(value = "name") String name) {
	        String rsp = "Hi " + name + " : responded on - " + new Date();
	        System.out.println(rsp);
	        return rsp;
	    }
	    @GetMapping("/")
	    String getMessagedefault() {
	        String rsp = "Hi Cloud" + " : responded on - " + new Date();
	        System.out.println(rsp);
	        return rsp;
	    }
	}
	
	   @Bean
	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	        return args -> {

	            System.out.println("Let's inspect the beans provided by Spring Boot:");

	            String[] beanNames = ctx.getBeanDefinitionNames();
	            Arrays.sort(beanNames);
	            for (String beanName : beanNames) {
	                System.out.println(beanName);
	            }

	        };
	    }
	
	
}
