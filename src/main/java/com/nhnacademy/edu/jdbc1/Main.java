package com.nhnacademy.edu.jdbc1;

import com.nhnacademy.edu.jdbc1.config.RootConfig;
import com.nhnacademy.edu.jdbc1.service.teacher.Teacher;
import com.nhnacademy.edu.jdbc1.service.teacher.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

public class Main {
    private static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class)) {
            TeacherService bean = ctx.getBean(TeacherService.class);

            log.info("1 teacher");
            log.info(bean.getTeacher(1L));
            log.info("all teachers");
            bean.getAllTeachers().forEach(log::info);

            bean.insertAndDelete(new Teacher(5L, "학생5", new Date(1)));
            log.info("after insert and delete");
            bean.getAllTeachers().forEach(log::info);

            try {
                bean.insertAndDelete(new Teacher(10L, "학생5", new Date(1)));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(log::info);

            try {
                bean.insertAndDeleteWithoutTransaction(new Teacher(10L, "학생5", new Date(1)));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(log::info);
        }
    }
}