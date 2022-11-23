package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.exception.ValidationFailedException;
import com.nhnacademy.edu.jdbc1.service.course.*;
import com.nhnacademy.edu.jdbc1.service.course.request.CourseRegisterRequest;
import com.nhnacademy.edu.jdbc1.service.course.request.CourseUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String insertCourseView(){
        return "courseInsert";
    }

    @PostMapping("/course/insert")
    public String insertCourse(@Valid @ModelAttribute CourseRegisterRequest request,
                               BindingResult result) throws SQLException {
        if (result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        courseCreationService.registerCourse(request);

        return "redirect:/course/select";
    }

    @GetMapping("/course/update")
    public String updateCourseView(){
        return "courseUpdate";
    }

    @PostMapping("/course/update")
    public String updateCourse(@Valid @ModelAttribute CourseUpdateRequest request,
                               BindingResult result) throws SQLException {

        if (result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        courseCreationService.updateCourse(request);

        return "redirect:/course/select";
    }

    @GetMapping("/course/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") long courseId) throws SQLException {
        courseCreationService.deleteCourse(courseId);

        return "redirect:/course/select";
    }

    @GetMapping("/course/select")
    public String selectCourses(Model model) throws SQLException {
        List<Course> courses = courseCreationService.getCourses();


        model.addAttribute("courses",courses);

        return "courseView";
    }

}
