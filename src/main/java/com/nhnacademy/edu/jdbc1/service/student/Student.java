package com.nhnacademy.edu.jdbc1.service.student;

import lombok.Getter;

import java.sql.Date;

@Getter
public class Student {

    private final Long id;
    private final String name;
    private final Date createdAt;

    public Student(Long id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}