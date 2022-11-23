package com.nhnacademy.edu.jdbc1.service.course;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class DefaultCourseCreationService implements CourseCreationService {

    CourseRepository courseRepository;
    Connection connection;

    public DefaultCourseCreationService(CourseRepository courseRepository, Connection connection) {
        this.courseRepository = courseRepository;
        this.connection = connection;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll(connection);
    }
}
