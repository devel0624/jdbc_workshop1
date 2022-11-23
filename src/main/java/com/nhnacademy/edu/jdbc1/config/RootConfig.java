package com.nhnacademy.edu.jdbc1.config;

import com.nhnacademy.edu.jdbc1.Base;
import com.nhnacademy.edu.jdbc1.service.course.CourseCreationService;
import com.nhnacademy.edu.jdbc1.service.course.CourseRepository;
import com.nhnacademy.edu.jdbc1.service.course.DefaultCourseCreationService;
import com.nhnacademy.edu.jdbc1.service.course.DefaultCourseRepository;
import com.nhnacademy.edu.jdbc1.service.login.DefaultUserRepository;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        try {
            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:comp/env/jdbc/test");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public Connection connection() throws SQLException {
        return dataSource().getConnection();
    }

    @Bean
    public CourseRepository courseRepository(){
        return new DefaultCourseRepository();
    }

    @Bean
    public CourseCreationService courseCreationService() throws SQLException {
        return new DefaultCourseCreationService(courseRepository(),connection());
    }

    @Bean
    public UserRepository userRepository(){
        return new DefaultUserRepository();
    }


}
