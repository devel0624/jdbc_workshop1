package com.nhnacademy.edu.jdbc1;

import com.nhnacademy.edu.jdbc1.service.student.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisMain {
    public static void main(String[] args) throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        Student student;
        try (SqlSession session = sqlSessionFactory.openSession()) {

            student = session.selectOne("selectStudent", 1);

            int a = session.insert("insertStudent",session);
        }

        System.out.println(student);
    }
}
