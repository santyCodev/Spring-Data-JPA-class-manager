package com.santycodev.springdatajpa_classmanager.repository;

import com.santycodev.springdatajpa_classmanager.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
