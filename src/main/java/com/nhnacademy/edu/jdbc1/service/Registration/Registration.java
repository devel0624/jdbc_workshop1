package com.nhnacademy.edu.jdbc1.service.Registration;

import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.student.Student;
import lombok.Getter;

import java.util.Date;

@Getter
public class Registration {

    private final Long id;
    private final Course course;
    private final Student student;
    private final Long score;
    private final Date created_at;

    public Registration(Long id, Course course, Student student, Long score, Date created_at) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.score = score;
        this.created_at = created_at;
    }

    public String toFormattedString() {
        return "Registration{" +
                "id=" + id +
                ", course_teacher_name=" + course.getTeacher().getName() +
                ", course_subject_name=" + course.getSubject().getName() +
                ", student_name=" + student.getName() +
                ", score=" + score +
                ", created_at=" + created_at +
                '}';
    }
}