package com.codeline.demo.Controllers;


import com.codeline.demo.Models.Student;
import com.codeline.demo.Services.CourseService;
import com.codeline.demo.Services.MarkService;
import com.codeline.demo.Services.SchoolService;
import com.codeline.demo.Services.StudentServices;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloControler {

    @Autowired
    StudentServices studentservices;

    @Autowired
    SchoolService schoolservice;

    @Autowired
    CourseService courseService;

    @Autowired
    MarkService markservice;

    @GetMapping
    public void addStudent() {

        studentservices.addStudent();
    }


    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentservices.getStudentsBySchoolName(schoolName);
    }


    @Autowired
    SlackClient slackClient;

    @GetMapping(value = "test")
    public String test() {
        return "${spring.profiles.active}";
    }

    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text) {
        slackClient.sendMessage(text);
    }
}

