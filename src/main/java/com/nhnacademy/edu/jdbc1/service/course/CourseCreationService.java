package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.service.course.request.CourseRegisterRequest;
import com.nhnacademy.edu.jdbc1.service.course.request.CourseUpdateRequest;

import java.sql.SQLException;
import java.util.List;

public interface CourseCreationService {

    List<Course> getCourses() throws SQLException;

    int registerCourse(CourseRegisterRequest request) throws SQLException;

    void updateCourse(CourseUpdateRequest request) throws SQLException;

    void deleteCourse(long courseId) throws SQLException;
}
