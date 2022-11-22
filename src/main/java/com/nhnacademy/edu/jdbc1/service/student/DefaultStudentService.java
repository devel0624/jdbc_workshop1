package com.nhnacademy.edu.jdbc1.service.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {
    private final StudentRepository studentRepository;

    public DefaultStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Student student) {
        studentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Student student) {
        studentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        studentRepository.deleteById(student.getId());
    }
}
