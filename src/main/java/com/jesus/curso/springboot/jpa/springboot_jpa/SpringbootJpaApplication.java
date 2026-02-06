package com.jesus.curso.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private Person repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override // CommandLineRunner
	public void run(String... args) throws Exception {
		// Create
		List<Person> persons = (List<Person>) repository.findAll();
		// Read
		persons.stream().forEach(person -> {
			System.out.println(person);
		});

	}

}
