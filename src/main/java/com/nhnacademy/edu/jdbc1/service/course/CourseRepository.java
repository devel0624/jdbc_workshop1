package com.nhnacademy.edu.jdbc1.service.course;


import com.nhnacademy.edu.jdbc1.service.subject.Subject;

import java.sql.Connection;
import java.util.List;

public interface CourseRepository {
    /**
     * TODO 01
     * findAll
     * findbyId
     * insert
     * delete
     * update
     */

    List<Course> findAll(Connection connection);
    Course findById(Connection connection,long id);
    int insert(Connection connection, Course course);
    int deleteById(Connection connection, long id);

    int updateSubjectById(Connection connection, long id, Subject subject);
}
