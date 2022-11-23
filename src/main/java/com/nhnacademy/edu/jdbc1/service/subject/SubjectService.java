package com.nhnacademy.edu.jdbc1.service.subject;

import java.util.List;

public interface SubjectService {
    Subject getSubject(long id);

    List<Subject> getAllSubjects();

    void insertAndDelete(Subject subject);

    void insertAndDeleteWithoutTransaction(Subject subject);
}
