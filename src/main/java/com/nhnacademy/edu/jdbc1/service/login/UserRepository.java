package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.service.course.Course;

import java.sql.Connection;

public interface UserRepository {
    User findByName(Connection connection, String name);

}
