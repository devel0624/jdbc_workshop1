package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.service.login.request.UserLoginRequest;

public interface UserLoginService {
    User getUserByName(String name);
    User login(UserLoginRequest request);
}
