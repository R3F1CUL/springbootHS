package com.r3f1cul.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of Students
        studentRepository.save(new Student("Jack", "Bauer"));
        studentRepository.save(new Student("Chloe", "O'Brian"));
        studentRepository.save(new Student("Kim", "Bauer"));
        studentRepository.save(new Student("David", "Palmer"));
        studentRepository.save(new Student("Michelle", "Dessler"));

        // fetch all Students
        System.out.println("Students found with findAll():");
        System.out.println("-------------------------------");
        for (Student Student : studentRepository.findAll()) {
            System.out.println(Student);
        }
        System.out.println();

        // fetch an individual Student by ID
        Student Student = studentRepository.findOne(1L);
        System.out.println("Student found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Student);
        System.out.println();

        // fetch Students by last name
        System.out.println("Student found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Student bauer : studentRepository.findByLastName("Bauer")) {
            System.out.println(bauer);
        }
    }
}