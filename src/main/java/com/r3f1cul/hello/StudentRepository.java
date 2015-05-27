package com.r3f1cul.hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by R3F1CUL on 5/26/2015.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findStudentByLastName(String lastName);

    Student[] findByLastName(String bauer);
}
