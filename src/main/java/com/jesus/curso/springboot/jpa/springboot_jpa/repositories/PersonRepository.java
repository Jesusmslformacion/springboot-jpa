package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// Repositorio JPA para la entidad Person
public interface PersonRepository extends CrudRepository<Person, Long> {

    // Método para encontrar una persona por su ID utilizando una consulta personalizada
    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    // Método para encontrar una persona por su nombre utilizando una consulta personalizada
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    // Método para encontrar una persona por su nombre utilizando la convención de nombres de Spring Data JPA
     @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    // Método para encontrar personas por su lenguaje de programación
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    // Método para encontrar personas por su lenguaje de programación y nombre
    @Query("select p from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String string);

    // Método para encontrar personas por su lenguaje de programación y nombre utilizando la convención de nombres de Spring Data JPA
    List<Person> findByProgrammingLanguageAndName(String string, String string2);

    // Método para obtener solo el nombre y el lenguaje de programación de las personas utilizando una consulta personalizada
    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();


    

}
