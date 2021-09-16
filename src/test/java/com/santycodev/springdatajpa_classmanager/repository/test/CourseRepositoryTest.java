package com.santycodev.springdatajpa_classmanager.repository.test;

import com.santycodev.springdatajpa_classmanager.entities.Course;
import com.santycodev.springdatajpa_classmanager.entities.Student;
import com.santycodev.springdatajpa_classmanager.entities.Teacher;
import com.santycodev.springdatajpa_classmanager.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        List<Course> courseList = repository.findAll();

        System.out.println("Courses = "+courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Pepe")
                .lastName("Trueno")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllCoursesPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,3);

        List<Course> courseList = repository.findAll(secondPageWithTwoRecords).getContent();
        long totalElements = repository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = repository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total elements = "+totalElements);
        System.out.println("Total pages = "+totalPages);
        System.out.println("Courses = "+courseList);
    }

    @Test
    public void findAllCoursesSorting() {
        Pageable pageSortByTitle = PageRequest.of(0,4, Sort.by("title"));

        Pageable pageSortByCreditDesc = PageRequest.of(0,4, Sort.by("credit").descending());

        Pageable pageSortByTitleAndCreditDesc = PageRequest.of(0,2,
                Sort.by("title").descending()
                        .and(Sort.by("credit")));

        List<Course> courseList = repository.findAll(pageSortByTitleAndCreditDesc).getContent();
        long totalElements = repository.findAll(pageSortByTitleAndCreditDesc).getTotalElements();
        long totalPages = repository.findAll(pageSortByTitleAndCreditDesc).getTotalPages();

        System.out.println("Total elements = "+totalElements);
        System.out.println("Total pages = "+totalPages);
        System.out.println("Courses = "+courseList);
    }

    @Test
    public void findByTitleContainingTest() {
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courseList = repository.findByTitleContaining("a", firstPageTenRecords).getContent();

        System.out.println("Num Courses = "+courseList.size());
        System.out.println("Courses = "+courseList);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Pedro")
                .lastName("Cordero")
                .build();

        Student student = Student.builder()
                .firstName("Rocco")
                .lastName("Sifreddi")
                .email("loco@pepe.com")
                .build();

        Course course = Course.builder()
                .title("Big Data")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        repository.save(course);
    }
}