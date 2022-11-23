package com.nhnacademy.edu.jdbc1.service.login;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserLoginRequest {

    @NotNull
    @NotBlank
    String name;

    @NotNull
    @NotBlank
    String pwd;
}
