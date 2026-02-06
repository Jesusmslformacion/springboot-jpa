package com.jesus.curso.springboot.jpa.springboot_jpa.dto;

public class PersonDto {

    // Atributos del DTO
    private String name;
    private String lastname;


    // Constructores
    public PersonDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    // Getters y Setters
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

    
}
