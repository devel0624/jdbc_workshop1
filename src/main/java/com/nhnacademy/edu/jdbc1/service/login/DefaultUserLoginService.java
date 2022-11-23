package com.nhnacademy.edu.jdbc1.service.login;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class DefaultUserLoginService implements UserLoginService{
    UserRepository userRepository;

    public DefaultUserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
