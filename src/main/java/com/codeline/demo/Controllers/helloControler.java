package com.codeline.demo.Controllers;


import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.Mark;
import com.codeline.demo.Models.School;
import com.codeline.demo.Models.Student;
import com.codeline.demo.Repositories.StudentInterface;
import com.codeline.demo.Services.CourseService;
import com.codeline.demo.Services.MarkService;
import com.codeline.demo.Services.SchoolService;
import com.codeline.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class helloControler {

    @Autowired
    StudentServices studentservices;

    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;

    @Autowired
    MarkService markService;
    @Autowired
    private StudentInterface studentInterface;

    @GetMapping
    public void addStudent() {
        studentservices.addStudent();
    }

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)

    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();

        return schools;
    }

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        List<Student> students = studentservices.getAllStudent();
        return students;
    }

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Course> getAllCourse() {
        List<Course> course = courseService.getAllCourse();
        return course;

    }

    @RequestMapping(value = "Mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks() {
        List<Mark> mark = markService.getAllMarks();

        return mark;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {

        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "school/getBySchoolName", method = RequestMethod.GET)
    public School getSchoolByName (@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
    }
        @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
        public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {

            return studentInterface.getStudentsBySchoolName(schoolName);

        }




    }

