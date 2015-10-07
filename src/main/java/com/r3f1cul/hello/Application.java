package com.r3f1cul.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {StudentController.class})
public class Application
    implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket petApi() {
        ApiInfo apiInfo = new ApiInfo("Api Documentation", "Student API", "1.0", "urn:tos",
            "fake@email", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.r3f1cul.hello"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .enableUrlTemplating(true)
            .apiInfo(apiInfo);
    }

    @Bean UiConfiguration uiConfig() {
        return new UiConfiguration(
            "validatorUrl");
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of Students
        studentRepository.save(new Student("Jack", "Bauer", 25));
        studentRepository.save(new Student("Chloe", "O'Brian", 88));
        studentRepository.save(new Student("Kim", "Bauer", 40));
        studentRepository.save(new Student("David", "Palmer", 21));
        studentRepository.save(new Student("Michelle", "Dessler", 99));

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
