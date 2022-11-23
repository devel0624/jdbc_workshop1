package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.exception.InvalidPassword;
import com.nhnacademy.edu.jdbc1.exception.UserNotFound;
import com.nhnacademy.edu.jdbc1.service.login.request.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Objects;

@Slf4j
@Service
public class DefaultUserLoginService implements UserLoginService{
    UserRepository userRepository;
    Connection connection;

    public DefaultUserLoginService(UserRepository userRepository,Connection connection) {
        this.connection = connection;
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByName(String name){
        return userRepository.findByName(connection,name);
    }

    @Override
    public User login(UserLoginRequest request){

        log.info("Login Service login");
        log.info(request.getName());
        log.info(request.getPwd());

        User user = getUserByName(request.getName());

        if(Objects.isNull(user)){
            throw new UserNotFound();
        }else if(!user.getPassword().equals(request.getPwd())){
            throw new InvalidPassword();
        }

        return user;
    }
}
