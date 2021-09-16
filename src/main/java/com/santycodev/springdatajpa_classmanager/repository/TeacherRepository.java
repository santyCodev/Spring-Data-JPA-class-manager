package com.santycodev.springdatajpa_classmanager.repository;

import com.santycodev.springdatajpa_classmanager.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
