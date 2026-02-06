package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// Repositorio JPA para la entidad Person
public interface PersonRepository extends CrudRepository<Person, Long> {

    // Método para obtener todas las personas utilizando una consulta personalizada
    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    // Método para obtener el nombre de una persona por su ID utilizando una consulta personalizada
    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);

    // Método para obtener el ID de una persona por su ID utilizando una consulta personalizada
    @Query("select p.id from Person p where p.id=?1")
    Long getById(Long id);

    @Query("select concat(p.name, ' ', p.lastname) as fullName from Person p where p.id=?1")
    String getFullNameById(Long id);







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
    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    // Método para obtener solo el ID, nombre, apellido y lenguaje de programación de las personas utilizando una consulta personalizada
    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataList();

    // Método para obtener solo el ID, nombre, apellido y lenguaje de programación de una persona por su ID utilizando una consulta personalizada
    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Object obtenerPersonDataById(Long id);

    // Método para obtener solo el nombre y el lenguaje de programación de las personas utilizando una consulta personalizada
    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();




    

}
