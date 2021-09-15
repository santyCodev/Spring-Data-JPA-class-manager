package com.santycodev.springdatajpa_classmanager.repository.test;

import com.santycodev.springdatajpa_classmanager.entities.Guardian;
import com.santycodev.springdatajpa_classmanager.entities.Student;
import com.santycodev.springdatajpa_classmanager.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("student1@gmail.com")
                .firstName("Student1")
                .lastName("app")
                /*.guardianName("guardStudent1")
                .guardianEmail("guardStudent1@gmail.com")
                .guardianMobile("666666666")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("guardStudent1")
                .email("guardStudent1@gmail.com")
                .mobile("666666666")
                .build();

        Student student = Student.builder()
                .email("student1@gmail.com")
                .firstName("Student1")
                .lastName("app")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Students = "+studentList);
    }

    @Test
    public void testStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Student1");

        System.out.println("Students = "+students);

        students = studentRepository.findByFirstName("Student2");

        System.out.println("Students = "+students);
    }

    @Test
    public void testStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Stu");

        System.out.println("Students = "+students);
    }

    @Test
    public void testFindByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("guardStudent1");

        System.out.println("Students = "+students);

        students = studentRepository.findByGuardianName("guardStudent2");

        System.out.println("Students = "+students);
    }

    @Test
    public void testGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("student1@gmail.com");

        System.out.println("Student = "+student);
    }

    @Test
    public void testGetStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("student1@gmail.com");

        System.out.println("Student = "+studentName);
    }

    @Test
    public void testGetStudentByEmailAddressNative() {
        String studentName = studentRepository.getStudentByEmailAddressNative("student1@gmail.com");

        System.out.println("Student = "+studentName);
    }

    @Test
    public void testGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("student1@gmail.com");

        System.out.println("Student = "+student);
    }

    @Test
    public void testUpdateStudentNameByEmail() {
        studentRepository.updateStudentNameByEmail("Student2","student2@gmail.com");
    }
}