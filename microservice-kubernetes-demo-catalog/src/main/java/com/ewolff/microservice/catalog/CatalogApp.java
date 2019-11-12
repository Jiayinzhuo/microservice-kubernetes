package com.ewolff.microservice.catalog;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@EnableAutoConfiguration
@Component
public class CatalogApp {

	private final ItemRepository itemRepository;

	@Autowired
	public CatalogApp(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PostConstruct
	public void generateTestData() {
		itemRepository.save(new Item("iPad", 329.0));
		itemRepository.save(new Item("iPad Air", 499.0));
		itemRepository.save(new Item("iPad mini", 399.0));
		itemRepository.save(new Item("iPad Pro", 699.0));
	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogApp.class, args);
	}

}
