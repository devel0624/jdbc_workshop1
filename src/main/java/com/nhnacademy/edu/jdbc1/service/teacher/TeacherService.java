package com.nhnacademy.edu.jdbc1.service.teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(long id);

    List<Teacher> getAllTeachers();

    void insertAndDelete(Teacher Teacher);

    void insertAndDeleteWithoutTransaction(Teacher Teacher);
}
