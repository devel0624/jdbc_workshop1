package com.nhnacademy.edu.jdbc1.service.login;

public interface UserLoginService {
    User getUserByName(String name);
    User login(UserLoginRequest request);
}
