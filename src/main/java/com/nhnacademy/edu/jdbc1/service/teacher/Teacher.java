package com.nhnacademy.edu.jdbc1.service.teacher;

import lombok.Getter;

import java.sql.Date;

@Getter
public class Teacher {

    private final Long id;
    private final String name;
    private final Date createdAt;

    public Teacher(Long id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}