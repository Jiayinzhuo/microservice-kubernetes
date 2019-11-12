package com.ewolff.microservice.customer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@EnableAutoConfiguration
@Component
public class CustomerApp {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerApp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void generateTestData() {
		customerRepository
				.save(new Customer("Jonathan", "Zhuo", "jonathan.zhuo@gmail.com", "100 Main Street", "New York"));
		customerRepository.save(new Customer("Rod", "Johnson", "rod@somewhere.com", "Market Street", "San Francisco"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}

}
