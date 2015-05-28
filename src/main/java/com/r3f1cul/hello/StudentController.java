package com.r3f1cul.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by R3F1CUL on 5/26/2015.
 */
@RestController
@EnableAutoConfiguration
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @RequestMapping("/students")
    private List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/students/lastName/{lastName}")
    private List<Student> getStudentByLastName(@PathVariable String lastName) {
        return studentRepository.findStudentsByLastName(lastName);
    }

    @ResponseBody
    @RequestMapping("/student/id/{id}")
    private Student findStudentById(@PathVariable Long id) {
        return studentRepository.findOne(id);
    }
}
