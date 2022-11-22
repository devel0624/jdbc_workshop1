package com.nhnacademy.edu.jdbc1.service.student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DefaultStudentRepository implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DefaultStudentRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Student findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcStudents  where id = ?",
                (resultSet, rowNum) ->
                        new Student(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("created_at")),
                id);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcStudents",
                (resultSet, rowNum) ->
                        new Student(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("created_at")));
    }

    @Override
    public int insert(Student student) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcStudents(id, name, created_at) VALUES (?,?,?)",
                student.getId(),
                student.getName(),
                student.getCreatedAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcStudents WHERE id=?",
                id
        );
    }
}
