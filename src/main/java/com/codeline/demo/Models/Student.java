package com.codeline.demo.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity

public class Student extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "student_name")
    String name;
    String rollNumber;


    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")

    School school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }



    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;


    }


























//    private String name;
//    @ManyToOne
//    @JoinColumn(name = "school_id", referencedColumnName = "id")
//    School school;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
