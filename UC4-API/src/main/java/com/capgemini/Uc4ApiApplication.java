package com.capgemini;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
@RefreshScope
@ComponentScan(basePackages="com.capgemini")
public class Uc4ApiApplication {
	@Value("${spring.application.name:Default}")
	private String name;

	public static void main(String[] args) {
		Uc4ApiApplication ucm =new Uc4ApiApplication();
		ucm.print();
		SpringApplication.run(Uc4ApiApplication.class, args);
		
	}
	void print() {
		System.out.print("App Name ********"+name);
	}
}
