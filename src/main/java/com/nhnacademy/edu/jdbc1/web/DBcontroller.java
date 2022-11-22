package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.service.student.Student;
import com.nhnacademy.edu.jdbc1.service.student.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Service
@RequestMapping("/daba")
public class DBcontroller {

    DataSource dataSource;
    StudentRepository studentRepository;

    public DBcontroller(DataSource dataSource,StudentRepository studentRepository){
        this.dataSource = dataSource;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String getDATAsource() throws SQLException {
        Connection connection = dataSource.getConnection();

        Student student = studentRepository.findById(1);

        log.info(String.valueOf(student));

        return "index";
    }
}
