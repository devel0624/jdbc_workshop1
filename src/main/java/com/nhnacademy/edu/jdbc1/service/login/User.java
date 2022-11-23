package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.service.subject.Subject;
import com.nhnacademy.edu.jdbc1.service.teacher.Teacher;
import lombok.Getter;

import java.sql.Date;

@Getter
public class User {
    private final Long id;
    private final String name;
    private final String password;
    private final Date createdAt;

    public User(Long id, String name, String password, Date createdAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
    }
}
