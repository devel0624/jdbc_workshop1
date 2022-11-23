package com.nhnacademy.edu.jdbc1.service.course.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CourseRegisterRequest {

    @NotNull
    long courseId;

    @NotNull
    long subjectId;

    @NotNull
    long teacherId;
}
