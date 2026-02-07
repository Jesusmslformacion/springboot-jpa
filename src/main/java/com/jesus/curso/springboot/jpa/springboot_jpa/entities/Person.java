package com.jesus.curso.springboot.jpa.springboot_jpa.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "persons") // Indica el nombre de la tabla en la base de datos
public class Person {

    @Id // Indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor se genera automáticamente
    // Atributos de la entidad
    private Long id;

    private String name;
    private String lastname;

    @Column(name = "programming_language") // Indica el nombre de la columna en la tabla
    private String programmingLanguage;

    
    // Constructor vacío
    public Person() {
    }

    

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }



    // Constructores
    public Person(Long id, String name, String lastname, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programmingLanguage;
    }



    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    // toString method
    @Override 
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", programmingLanguage="
                + programmingLanguage + "]";
    }

    // Método para simular la consulta a la base de datos
    public List<Person> findAll() {
        return null;
        
    }

    public List<Person> findByProgrammingLanguage(String string) {
        return null;
    }

    
    

}
