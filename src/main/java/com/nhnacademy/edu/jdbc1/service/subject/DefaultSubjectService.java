package com.nhnacademy.edu.jdbc1.service.subject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultSubjectService implements SubjectService {
    private final SubjectRepository subjectRepository;

    public DefaultSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject getSubject(long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Subject subject) {
        subjectRepository.insert(subject);
        if (subject.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        subjectRepository.deleteById(subject.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Subject subject) {
        subjectRepository.insert(subject);
        if (subject.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        subjectRepository.deleteById(subject.getId());
    }
}
