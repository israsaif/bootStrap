package com.codeline.demo.Models;

import javax.persistence.*;

@Entity
public class Course extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "course_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;

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

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
}
