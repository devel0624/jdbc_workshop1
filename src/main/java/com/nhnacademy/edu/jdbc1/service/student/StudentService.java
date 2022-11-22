package com.nhnacademy.edu.jdbc1.service.student;

import java.util.List;

public interface StudentService {
    Student getStudent(long id);

    List<Student> getAllStudents();

    void insertAndDelete(Student student);

    void insertAndDeleteWithoutTransaction(Student student);
}
