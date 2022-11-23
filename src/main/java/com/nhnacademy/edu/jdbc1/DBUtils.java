package com.nhnacademy.edu.jdbc1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DBUtils {

    private static final DataSource DATASOURCE;

    private DBUtils() {
    }

    public static Connection getConnection() {
        try {
            log.info("Driver Manager Get Connection Succecss");

            return DriverManager.getConnection(
                    "jdbc:mysql://133.186.151.141:3306/nhn_academy_32",
                    "nhn_academy_32",
                    "EJdrW!(bf]HjT9a5");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATASOURCE;
    }

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.151.141:3306/nhn_academy_32");
        basicDataSource.setUsername("nhn_academy_32");
        basicDataSource.setPassword("EJdrW!(bf]HjT9a5");
        basicDataSource.setMaxWaitMillis(2);
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(10);

        DATASOURCE = basicDataSource;

    }
}
