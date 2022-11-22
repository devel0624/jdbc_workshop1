package com.nhnacademy.edu.jdbc1.service.teacher;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DefaultTeacherRepository implements TeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    public DefaultTeacherRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Teacher findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcTeachers  where id = ?",
                (resultSet, rowNum) ->
                        new Teacher(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("created_at")),
                id);
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcTeachers",
                (resultSet, rowNum) ->
                        new Teacher(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("created_at")));
    }

    @Override
    public int insert(Teacher teacher) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcTeachers(id, name, created_at) VALUES (?,?,?)",
                teacher.getId(),
                teacher.getName(),
                teacher.getCreatedAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcTeachers WHERE id=?",
                id
        );
    }
}
