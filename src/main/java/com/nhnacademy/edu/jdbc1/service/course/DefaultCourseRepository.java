package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.service.subject.Subject;
import com.nhnacademy.edu.jdbc1.service.teacher.Teacher;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCourseRepository implements CourseRepository {
    @Override
    public List<Course> findAll(Connection connection) {
        String sql =
                "SELECT c.id as c_id, c.teacher_id as c_teacher_id, c.subject_id as c_subject_id, c.created_at as c_created_at,\n" +
                        "       s.id as s_id, s.name, s.created_at, \n" +
                        "       t.id as t_id, t.name, t.created_at\n" +
                        "    FROM JdbcCourses as c\n" +
                        "       INNER JOIN JdbcSubjects as s ON c.subject_id = s.id\n" +
                        "       INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id\n;";

        try (PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();

            List<Course> courses = new ArrayList<>();

            while (rs.next()){

                Teacher teacher = new Teacher(
                        rs.getLong("t_id"),
                        rs.getString("t.name"),
                        rs.getDate("t.created_at")
                );

                Subject subject = new Subject(
                        rs.getLong("s_id"),
                        rs.getString("s.name"),
                        rs.getDate("s.created_at")
                );
                Course course = new Course(
                        rs.getLong("c_id"),
                        subject,
                        teacher,
                        rs.getDate("c_created_at")
                );

                courses.add(course);
            }
            return courses;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course findById(Connection connection, long id) {
        String sql =
                "SELECT c.id as c_id, c.teacher_id as c_teacher_id, c.subject_id as c_subject_id, c.created_at as c_created_at,\n" +
                        "       s.id as s_id, s.name, s.created_at, \n" +
                        "       t.id as t_id, t.name, t.created_at\n" +
                        "    FROM JdbcCourses as c\n" +
                        "       INNER JOIN JdbcSubjects as s ON c.subject_id = s.id\n" +
                        "       INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id\n" +
                        "   WHERE id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1,id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){

                Teacher teacher = new Teacher(
                        rs.getLong("t_id"),
                        rs.getString("t.name"),
                        rs.getDate("t.created_at")
                );

                Subject subject = new Subject(
                        rs.getLong("s_id"),
                        rs.getString("s.name"),
                        rs.getDate("s.created_at")
                );

                return new Course(
                        rs.getLong("c_id"),
                        subject,
                        teacher,
                        rs.getDate("c_created_at")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public int insert(Connection connection, Course course) {
        String sql = "INSERT INTO JdbcCourses (id, subject_id, teacher_id, created_at) VALUES (?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, course.getId());
            statement.setLong(2, course.getSubject().getId());
            statement.setLong(3, course.getTeacher().getId());
            statement.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));

            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(Connection connection, long id) {
        String sql = "DELETE FROM JdbcCourses WHERE id = ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, id);

            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateSubjectById(Connection connection, long id, Subject subject) {
        String sql = "UPDATE JdbcCourses SET subject_id = ? WHERE id = ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setLong(1, subject.getId());
            statement.setLong(2, id);

            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
