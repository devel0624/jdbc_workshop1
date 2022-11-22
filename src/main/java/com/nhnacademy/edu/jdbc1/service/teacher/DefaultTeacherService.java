package com.nhnacademy.edu.jdbc1.service.teacher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultTeacherService implements TeacherService {
    private final TeacherRepository teacherRepository;

    public DefaultTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher getTeacher(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Teacher teacher) {
        teacherRepository.insert(teacher);
        if (teacher.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        teacherRepository.deleteById(teacher.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Teacher teacher) {
        teacherRepository.insert(teacher);
        if (teacher.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        teacherRepository.deleteById(teacher.getId());
    }
}
