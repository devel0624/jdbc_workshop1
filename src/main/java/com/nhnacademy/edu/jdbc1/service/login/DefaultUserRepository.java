package com.nhnacademy.edu.jdbc1.service.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultUserRepository implements UserRepository {
    @Override
    public User findByName(Connection connection, String name) {
        String sql =
                "SELECT * FROM JdbcUsers WHERE username = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                return new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
