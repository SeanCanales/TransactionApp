package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionAppApplication implements CommandLineRunner	{
	
	@Autowired
	CRUDmethods crudMethods;

	public static void main(String[] args) {
		SpringApplication.run(TransactionAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Transaction t = new Transaction(23, "Furniture", "IKEA", "Lawn Chair", 23.99);
		crudMethods.create(t);
		
	}

}
