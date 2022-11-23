package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.service.course.request.CourseRegisterRequest;
import com.nhnacademy.edu.jdbc1.service.course.request.CourseUpdateRequest;
import com.nhnacademy.edu.jdbc1.service.subject.DefaultSubjectRepository;
import com.nhnacademy.edu.jdbc1.service.subject.Subject;
import com.nhnacademy.edu.jdbc1.service.subject.SubjectRepository;
import com.nhnacademy.edu.jdbc1.service.teacher.DefaultTeacherRepository;
import com.nhnacademy.edu.jdbc1.service.teacher.Teacher;
import com.nhnacademy.edu.jdbc1.service.teacher.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class DefaultCourseCreationService implements CourseCreationService {

    CourseRepository courseRepository;
    DataSource dataSource;

    public DefaultCourseCreationService(CourseRepository courseRepository, DataSource dataSource) {
        this.courseRepository = courseRepository;
        this.dataSource = dataSource;
    }

    @Override
    public List<Course> getCourses() throws SQLException {
        return courseRepository.findAll(dataSource.getConnection());
    }

    @Override
    public int registerCourse(CourseRegisterRequest request) throws SQLException {
        SubjectRepository subjectRepository = new DefaultSubjectRepository(dataSource);
        TeacherRepository teacherRepository = new DefaultTeacherRepository(dataSource);


        Subject subject = subjectRepository.findById(request.getSubjectId());
        Teacher teacher = teacherRepository.findById(request.getTeacherId());

        Course course = new Course(request.getCourseId(),subject,teacher,null);

        return courseRepository.insert(dataSource.getConnection(),course);

    }

    @Override
    public void updateCourse(CourseUpdateRequest request) throws SQLException {
        SubjectRepository subjectRepository = new DefaultSubjectRepository(dataSource);

        Subject subject = subjectRepository.findById(request.getSubjectId());

        courseRepository.updateSubjectById(dataSource.getConnection(),request.getCourseId(),subject);
    }

    @Override
    public void deleteCourse(long courseId) throws SQLException {
        courseRepository.deleteById(dataSource.getConnection(),courseId);
    }
}
