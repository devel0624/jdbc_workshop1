package com.nhnacademy.edu.jdbc1.service.student;

import java.util.List;

public interface StudentRepository {
    Student findById(long id);

    List<Student> findAll();

    int insert(Student student);

    int deleteById(long id);
}

