package com.nhnacademy.edu.jdbc1.config;

import com.nhnacademy.edu.jdbc1.Base;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {

}
