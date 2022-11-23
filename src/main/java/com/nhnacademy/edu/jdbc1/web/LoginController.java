package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.exception.UserNotFound;
import com.nhnacademy.edu.jdbc1.exception.ValidationFailedException;
import com.nhnacademy.edu.jdbc1.service.login.User;
import com.nhnacademy.edu.jdbc1.service.login.UserLoginRequest;
import com.nhnacademy.edu.jdbc1.service.login.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@Controller
public class LoginController {

    UserLoginService service;

    public LoginController(UserLoginService userLoginService){
        service = userLoginService;
    }

    @GetMapping("/login")
    public String redirectLoginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String tryLogin(@Valid @ModelAttribute UserLoginRequest request,
                           BindingResult result,
                           ModelAndView model){

        log.info("Post Login");

        log.info(request.getName());
        log.info(request.getPwd());

        if (result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        User user = service.login(request);

        log.info("" + user);

        return "redirect:/course";
    }
}
