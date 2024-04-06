package com.myapp.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "serial_no")
    private Long serialno;

    @Column(name = "username", unique = true, nullable = false )
    private String username;

    @Column(name = "adminpassword", nullable = false)
    private String adminpassword;

    public String getUsername() {
        return username;
    }
}
