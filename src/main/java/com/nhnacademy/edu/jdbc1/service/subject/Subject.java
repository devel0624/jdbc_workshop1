package com.nhnacademy.edu.jdbc1.service.subject;

import lombok.Getter;

import java.util.Date;


@Getter
public class Subject {
    private final Long id;
    private final String name;
    private final Date createdAt;

    public Subject(Long id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

