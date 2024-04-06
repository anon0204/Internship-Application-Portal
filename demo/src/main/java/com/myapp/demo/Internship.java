package com.myapp.demo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "internship")
@Getter
@Setter
public class Internship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serial_no", nullable = false)
    private Integer serialno; 

    @Column(name="student_id", nullable= false)
    private Long studentId;

    @Column(name = "internship_id", nullable = false)
    private String internshipId;

    @Column(name = "company_name", nullable = false)
    private String companyname;

    @Column(name = "company_office", nullable = false)
    private String companyoffice;

    @Column(name = "start_date", nullable = false)
    private String startdate;

    @Column(name = "end_date", nullable = false)
    private String enddate;
    
    @Column(name = "start_time", nullable = false)
    private String starttime; 

    @Column(name = "end_time", nullable = false)
    private String endtime; 

    @Column(name = "position", nullable = false)
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode", nullable = false)
    private Mode mode;

    @Column(name = "stipend", nullable = false)
    private String stipend;

    @Column(name="work_address", nullable = false)
    private String workaddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "password", nullable = false)
    private String password;

    public String getInternshipId() {
        return internshipId;
    }
}








