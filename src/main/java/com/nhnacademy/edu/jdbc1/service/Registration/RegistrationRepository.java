package com.nhnacademy.edu.jdbc1.service.Registration;

import com.nhnacademy.edu.jdbc1.service.student.Student;

import java.sql.Connection;
import java.util.List;

public interface RegistrationRepository {

    List<Registration> findAll(Connection connection);

    Registration findById(long id);

    int insert(Registration registration);

    int deleteById(long id);
}