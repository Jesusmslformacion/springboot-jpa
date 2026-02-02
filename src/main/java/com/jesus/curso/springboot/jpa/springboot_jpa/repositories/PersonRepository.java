package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// Repositorio JPA para la entidad Person
public interface PersonRepository extends CrudRepository<Person, Long> {



    

}
