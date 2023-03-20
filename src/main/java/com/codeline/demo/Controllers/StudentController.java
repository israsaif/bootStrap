package com.codeline.demo.Controllers;

import com.codeline.demo.Models.Student;
import com.codeline.demo.Services.StudentServices;
import com.codeline.demo.Slack.SlackClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentServices studentService;

@Autowired
    SlackClient slackClient;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)

    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {

        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "/getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String student_name) {
        Student studentName = studentService.getStudentByName(student_name);
        return studentName;
    }


    @RequestMapping(value = "/getAllStudentByIsActive")
    public List<Student> getAllActiveStudent() {
        List<Student> activeStudentList = studentService.getAllActiveStudent();
        return activeStudentList;
    }

    @RequestMapping(value = "/getAllStudentByIsUnActive")
    public List<Student> getAllUnActiveStudent() {
        List<Student> notActiveStudentList = studentService.getAllUnActiveStudent();
        return notActiveStudentList;
    }

//    @RequestMapping(value = "/getStudentLatestRow")
//    public List<Student> getStudentLatestRow() {
//        List<Student> studentLatestRowList = studentService.getStudentLatestRow();
//        return studentLatestRowList;
//    }



}
