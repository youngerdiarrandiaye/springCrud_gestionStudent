package com.groupeisi.gestionetudiant;

import com.groupeisi.gestionetudiant.entities.Student;
import com.groupeisi.gestionetudiant.repossitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GestionetudiantApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionetudiantApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		//Student student1 = new Student("youssou","yousou","you");
		//studentRepository.save(student1);
		studentRepository.findAll().forEach(p->System.out.println(p.getFirstname()));
	}
}
