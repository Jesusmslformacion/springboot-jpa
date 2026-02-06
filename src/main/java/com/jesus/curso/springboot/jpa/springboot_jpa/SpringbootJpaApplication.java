package com.jesus.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;
import com.jesus.curso.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override // CommandLineRunner
	public void run(String... args) throws Exception {
		
		personalizedQueries2();
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2() { // Método para realizar consultas personalizadas utilizando el repositorio JPA
		System.out.println("========== Consultas por objeto persona y lenguaje de programación ==========");
		List<Object[]> personRegs = repository.findAllMixPerson(); // Obtiene los campos personalizados de la persona por su ID utilizando una consulta personalizada

		personRegs.forEach(reg -> {
			System.out.println("programmingLanguage: " + reg[1] + ", Person: " + reg[0]);
		}); // Imprime los campos personalizados obtenidos

		System.out.println("========== Consulta que puebla y devuelve objeto entidad persona personalizada ==========");
		List<Person> persons = repository.findAllObjectPersonPersonalized(); // Obtiene los campos personalizados de la persona por su ID utilizando una consulta personalizada
		persons.forEach(System.out::println);
		 // Imprime los campos personalizados obtenidos
	}	

	@Transactional(readOnly = true)
	public void personalizedQueries() { // Método para realizar consultas personalizadas utilizando el repositorio JPA

		Scanner scanner = new Scanner(System.in);

		System.out.println("========== Consultas Personalizadas ==========");
		System.out.println("Ingresa el ID de la persona: ");
		Long id = scanner.nextLong(); // Lee el ID ingresado por el usuario
		scanner.close(); // Cierra el scanner para liberar recursos
		
		System.out.println("========== Mostrando solo el nombre por el ID ==========");
		String name = repository.getNameById(id); // Obtiene el nombre de la persona por su ID utilizando una consulta personalizada
		System.out.println(name); // Imprime el nombre obtenido

		System.out.println("========== Mostrando solo el ID por el ID ==========");
		Long idDb = repository.getById(id); // Obtiene el ID de la persona por su ID utilizando una consulta personalizada
		System.out.println(idDb); // Imprime el ID obtenido

		System.out.println("========== Mostrando el nombre completo por el ID ==========");
		String fullName = repository.getFullNameById(id); // Obtiene el nombre completo de la persona por su ID utilizando una consulta personalizada
		System.out.println(fullName); // Imprime el nombre completo obtenido

		System.out.println("========== Consultas por campos personalizados por el ID ==========");
		Object[] personReg = (Object[]) repository.obtenerPersonDataById(id); // Obtiene los campos personalizados de la persona por su ID utilizando una consulta personalizada
		System.out.println("ID: " + personReg[0] + ", Nombre: " + personReg[1] + ", Apellido: " + personReg[2] + ", Lenguaje de Programación: " + personReg[3]); // Imprime los campos personalizados obtenidos

		System.out.println("========== Consultas por campos personalizados de todas las personas ==========");
		List<Object[]> regs = repository.obtenerPersonDataList(); // Obtiene los campos personalizados de todas las personas utilizando una consulta personalizada
		regs.forEach(reg -> System.out.println("ID: " + reg[0] + ", Nombre: " + reg[1] + ", Apellido: " + reg[2] + ", Lenguaje de Programación: " + reg[3])); // Imprime los campos personalizados obtenidos para cada persona
	}

	@Transactional
	public void delete2() { // Método para eliminar una persona existente utilizando el método delete del repositorio JPA

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el ID de la persona a eliminar: ");
		Long id = scanner.nextLong(); // Lee el ID ingresado por el usuario
		
		Optional<Person> optionalPerson = repository.findById(id); // Busca la persona por su ID

		optionalPerson.ifPresentOrElse(repository::delete, 
		() -> System.out.println("La persona no existe")); // Elimina la persona si existe, de lo contrario muestra un mensaje

		repository.findAll().forEach(System.out::println);

		scanner.close(); // Cierra el scanner para liberar recursos
	}

	@Transactional
	public void delete() { // Método para eliminar una persona existente

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el ID de la persona a eliminar: ");
		Long id = scanner.nextLong(); // Lee el ID ingresado por el usuario
		repository.deleteById(id); // Elimina la persona por su ID utilizando el repositorio JPA

		repository.findAll().forEach(System.out::println);
	
		scanner.close(); // Cierra el scanner para liberar recursos
	}

	@Transactional
	public void update () { // Método para actualizar una persona existente

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el ID de la persona a actualizar: ");
		Long id = scanner.nextLong(); // Lee el ID ingresado por el usuario

		Optional<Person> optionalPerson = repository.findById(id); // Busca la persona por su ID

		optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programacion");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb = repository.save(person);
			System.out.println(personDb);
		});

		scanner.close(); // Cierra el scanner para liberar recursos
	}

	@Transactional(readOnly = true) // Anotación para indicar que el método es de solo lectura y no realizará modificaciones en la base de datos
	public void create() { // Método para crear una nueva persona

		// Scanner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el nombre: ");
		String name = scanner.next(); // Lee el nombre ingresado por el usuario
		System.out.println("Ingresa el apellido: ");
		String lastname = scanner.next(); // Lee el apellido ingresado por el usuario
		System.out.println("Ingresa el lenguaje de programación: ");
		String programmingLanguage = scanner.next(); // Lee el lenguaje de programación ingresado por el usuario
		scanner.close(); // Cierra el scanner para liberar recursos
		
		// Crea un nuevo objeto Person con los datos ingresados por el usuario
		Person person = new Person(null,name, lastname, programmingLanguage);

		// Guarda la persona en la base de datos utilizando el repositorio JPA
		Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(p -> System.out.println(p)); // Si la persona existe, se imprime su información
	}

	// Método para encontrar una persona por su ID
	public void findOne() { // Método para encontrar una persona por su ID
		//Person person = null;
		//Optional<Person> optionalPerson = repository.findById(1L); // Busca la persona con ID 1
		// Si la persona existe, se obtiene el objeto Person, de lo contrario se deja como null
		//if(optionalPerson.isPresent()) {
			//person = optionalPerson.get();
		//}
		//System.out.println(person);
		repository.findByNameContaining("se").ifPresent(System.out::println); // Si la persona existe, se imprime su información
	}

	public void list() {

		// Create
		//List<Person> persons = (List<Person>) repository.findAll();
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Andres");

		// Read
		persons.stream().forEach(person -> {
			System.out.println(person);
		});

		// Update
		List<Object[]> personsValues = repository.obtenerPersonData();
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es un programador de " + person[1]);
			
		});
	}

}
