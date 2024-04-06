package com.myapp.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "middle_name", nullable = false)
    private String middlename;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "branch", nullable = false)
    private Branch branch;

    @Column(name = "semester", nullable = false)
    private Integer semester; 

    @Column(name  = "address", nullable = false)
    private String address;

    @Column(name = "mobile_no", nullable = false)
    private Long mobileno;

    @Column(name = "college_email", nullable = false, unique = true)
    private String email;

    @Column(name = "personal_email", nullable = false, unique = true)
    private String personalmail;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_check", nullable = false)
    private String passwordCheck;

    public Long getId() {
        return studentId;
    }
}
