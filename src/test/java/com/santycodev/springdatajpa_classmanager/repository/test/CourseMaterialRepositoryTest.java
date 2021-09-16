package com.santycodev.springdatajpa_classmanager.repository.test;

import com.santycodev.springdatajpa_classmanager.entities.Course;
import com.santycodev.springdatajpa_classmanager.entities.CourseMaterial;
import com.santycodev.springdatajpa_classmanager.repository.CourseMaterialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterial() {
        List<CourseMaterial> courseMaterialList = repository.findAll();

        System.out.println("CourseMaterials = "+courseMaterialList);
    }
}