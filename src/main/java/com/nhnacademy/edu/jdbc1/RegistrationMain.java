package com.nhnacademy.edu.jdbc1;

import com.nhnacademy.edu.jdbc1.service.Registration.DefaultRegistrationRepository;
import com.nhnacademy.edu.jdbc1.service.Registration.Registration;
import com.nhnacademy.edu.jdbc1.service.Registration.RegistrationRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationMain {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DBUtils.getDataSource().getConnection()) {

            RegistrationRepository registrationRepository = new DefaultRegistrationRepository();
            registrationRepository.findAll(connection)
                    .stream()
                    .map(Registration::toFormattedString)
                    .forEach(System.out::println);

        }
    }
}
