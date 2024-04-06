package com.myapp.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Integer> {

    boolean existsByStudentId(Long studentId);

    Internship findByInternshipId(String internshipId);

    boolean existsByInternshipId(String internshipId);

    Student findByStudentId(Long studentId);

    List<Internship> findAllByStudentIdAndPassword(Long studentId, String password);

    List<Internship> findAllByStudentId(Long studentId);
}
