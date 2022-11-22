package com.nhnacademy.edu.jdbc1.config;

import com.nhnacademy.edu.jdbc1.Base;
import com.nhnacademy.edu.jdbc1.service.login.JdbcUserRepository;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
import com.nhnacademy.edu.jdbc1.service.student.DefaultStudentRepository;
import com.nhnacademy.edu.jdbc1.service.student.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        try {
            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:comp/env/jdbc/nhn_academy_32");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public StudentRepository studentRepository(DataSource dataSource){
        return new DefaultStudentRepository(dataSource);
    }

    @Bean
    public UserRepository userRepository(){
        return new JdbcUserRepository();
    }


}
