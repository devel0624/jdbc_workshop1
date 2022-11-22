package com.nhnacademy.edu.jdbc1.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

public class DatabaseConfig {
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.151.141:3306/nhn_academy_32");
        basicDataSource.setUsername("nhn_academy_32");
        basicDataSource.setPassword("EJdrW!(bf]HjT9a5");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(20);

        return basicDataSource;
    }

    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
