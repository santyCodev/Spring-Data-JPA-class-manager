package com.santycodev.springdatajpa_classmanager.repository.test;

import com.santycodev.springdatajpa_classmanager.entities.Course;
import com.santycodev.springdatajpa_classmanager.entities.Teacher;
import com.santycodev.springdatajpa_classmanager.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {

        Course course2 = Course.builder()
                .title("Java")
                .credit(7)
                .build();

        Course course = Course.builder()
                .title("Angular")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("teacher1")
                .lastName("garcia")
                //.courses(Arrays.asList(course, course2))
                //.courses(List.of(course)) - only Java 9
                .build();

        repository.save(teacher);
    }
}