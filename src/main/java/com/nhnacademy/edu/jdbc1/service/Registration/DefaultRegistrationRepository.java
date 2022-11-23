package com.nhnacademy.edu.jdbc1.service.Registration;

import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.student.Student;
import com.nhnacademy.edu.jdbc1.service.subject.Subject;
import com.nhnacademy.edu.jdbc1.service.teacher.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultRegistrationRepository implements RegistrationRepository {
    @Override
    public List<Registration> findAll(Connection connection) {
        String sql =
                "SELECT r.id as r_id, r.course_id , r.student_id, r.score, r.created_at as r_created_at,\n" +
                "       s.id as s_id, s.name, s.created_at, \n" +
                "       c.id as c_id, c.teacher_id as c_teacher_id, c.subject_id as c_subject_id, c.created_at as c_created_at,\n" +
                "       su.id as su_id, su.name, su.created_at, \n" +
                "       t.id as t_id, t.name, t.created_at\n" +
                        "FROM JdbcRegistrations as r\n" +
                "    INNER JOIN JdbcCourses as c ON r.course_id = c.id \n" +
                "       INNER JOIN JdbcSubjects as su ON c.subject_id = su.id\n" +
                "       INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id\n" +
                "    INNER JOIN JdbcStudents as s ON r.student_id = s.id;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();

            List<Registration> registrations = new  ArrayList<>();

            while (rs.next()){
                Student student = new Student(
                        rs.getLong("s_id"),
                        rs.getString("s.name"),
                        rs.getDate("s.created_at")
                );

                Teacher teacher = new Teacher(
                        rs.getLong("t_id"),
                        rs.getString("t.name"),
                        rs.getDate("t.created_at")
                );

                Subject subject = new Subject(
                        rs.getLong("su_id"),
                        rs.getString("su.name"),
                        rs.getDate("su.created_at")
                );

                Course course = new Course(
                        rs.getLong("c_id"),
                        subject,
                        teacher,
                        rs.getDate("c_created_at")
                );

                Registration registration = new Registration(
                        rs.getLong("r_id"),
                        course,
                        student,
                        rs.getLong("r.score"),
                        rs.getDate("r_created_at")
                );

                registrations.add(registration);
            }

            return registrations;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Registration findById(long id) {
        return null;
    }

    @Override
    public int insert(Registration registration) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }
}
