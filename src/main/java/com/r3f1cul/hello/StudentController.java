package com.r3f1cul.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    private List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/students/lastName/{lastName}", method = RequestMethod.GET, produces = "application/json")
    private List<Student> getStudentByLastName(@PathVariable String lastName) {
        return studentRepository.findStudentsByLastName(lastName);
    }

    @ResponseBody
    @RequestMapping(value = "/student/id/{id}", method = RequestMethod.GET, produces = "application/json")
    private Student findStudentById(@PathVariable long id) {
        return studentRepository.findOne(id);
    }
}
