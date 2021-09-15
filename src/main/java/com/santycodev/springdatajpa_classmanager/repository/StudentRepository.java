package com.santycodev.springdatajpa_classmanager.repository;

import com.santycodev.springdatajpa_classmanager.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    //Methods jpa
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    //Query annotation JPQL
    @Query("select s from Student s where s.email = ?1")
    public Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    public String getStudentFirstNameByEmailAddress(String email);

    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public String getStudentByEmailAddressNative(String email);

    //Native Named Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :email",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmail(String firstName, String email);
}
