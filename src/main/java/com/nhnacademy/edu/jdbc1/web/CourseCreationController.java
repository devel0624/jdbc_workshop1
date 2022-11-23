package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.config.RootConfig;
import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.course.CourseCreationService;
import com.nhnacademy.edu.jdbc1.service.course.CourseRepository;
import com.nhnacademy.edu.jdbc1.service.course.DefaultCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
public class CourseCreationController {

    CourseCreationService courseCreationService;

    public CourseCreationController(CourseCreationService courseCreationService) {
        this.courseCreationService = courseCreationService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/course")
    public String menu(){
        return "courseMenu";
    }

    @GetMapping("/course/insert")
    public String insertCourse(){
        return "courseInsert";
    }

    @GetMapping("/course/select")
    public String selectCourses(Model model){
        List<Course> courses = courseCreationService.getCourses();


        model.addAttribute("courses",courses);

        return "courseView";
    }

}
