package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// Repositorio JPA para la entidad Person
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByIdBetween(Long id1,Long id2);

    List<Person> findByNameBetween(String name1, String name2);

    @Query("select p from Person p where p.name between ?1 and ?2order by p.name")
    List<Person> findAllBetweenName(String c1, String c2);

    @Query("select p from Person p where p.id between ?1 and ?2order by p.name")
    List<Person> findAllBetweenId(Long id1, Long id2); 

    @Query("select p.id, upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
    List<Object[]> findAllPersonDataListCase();

    @Query("select upper(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullNameConcatUpper();// Método para obtener el nombre completo de las personas en mayúsculas utilizando una consulta personalizada

    @Query("select lower(concat(p.name || ' ' || p.lastname)) from Person p")
    List<String> findAllFullNameConcatLower(); // Método para obtener el nombre completo de las personas en minúsculas utilizando una consulta personalizada

    //@Query("select concat(p.name, ' ', p.lastname) from Person p")
    @Query("select p.name || ' ' || p.lastname from Person p")
    List<String> findAllFullNameConcat(); // Método para obtener el nombre completo de las personas utilizando una consulta personalizada

    @Query("select count (distinct(p.programmingLanguage)) from Person p")
    Long findAllProgrammingLanguagesDistinctCount(); // Método para obtener el número de lenguajes de programación distintos de las personas utilizando una consulta personalizada

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguagesDistinct(); // Método para obtener solo los lenguajes de programación distintos de las personas utilizando la convención de nombres de Spring Data JPA

    @Query("select p.name from Person p")
    List<String> findAllNames(); // Método para obtener solo los nombres de las personas utilizando la convención de nombres de Spring Data JPA

    
    @Query("select distinct (p.name) from Person p")
    List<String> findAllNamesDistinct(); // Método para obtener solo los nombres distintos de las personas utilizando la convención de nombres de Spring Data JPA

    @Query("select new com.jesus.curso.springboot.jpa.springboot_jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllPersonDto();


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
