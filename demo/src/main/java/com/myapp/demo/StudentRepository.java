package com.myapp.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    boolean existsBystudentId(Long studentId);

    Student findByStudentId(Long studentId);

    Student findByPassword(String password);

    Student findByPersonalmail(String personalmail);

    Student findByPersonalmailAndPassword(String personalmail, String password);

    

}
