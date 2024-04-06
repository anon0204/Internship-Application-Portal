package com.myapp.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "registration")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "college_email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_check", nullable = false)
    private String passwordCheck;

    public Long getId() {
        return studentId;
    }
}
