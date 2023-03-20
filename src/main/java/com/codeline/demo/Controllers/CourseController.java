package com.codeline.demo.Controllers;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.School;
import com.codeline.demo.Models.Student;
import com.codeline.demo.Repositories.CourseInterface;
import com.codeline.demo.Services.CourseService;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
        @Autowired
        CourseService courseService;
    @Autowired
    SlackClient slackClient;
        @Autowired
        private CourseInterface courseInterface;

        @RequestMapping(value = "/getAll", method = RequestMethod.GET)
        public List<Course> getAllCourse() {
            List<Course> course = courseService.getAllCourse();
            return course;
        }

        @RequestMapping(value = "/getById", method = RequestMethod.GET)
        public Course getCourseById(@RequestParam Integer courseId) {

            Course course = courseService.getCourseById(courseId);
            return course;
        }

        @RequestMapping(value = "/getByCourseName", method = RequestMethod.GET)
        public Course getByCourseName(@RequestParam String course_name) {
            Course courseName = courseInterface.getCourseByName(course_name);
            return courseName;
        }

    @RequestMapping(value = "/getAllCourseByIsActive")
    public List<Course> getAllActiveCourse() {
        List<Course> activeCourseList = courseService.getAllActiveCourse();
        return activeCourseList;
    }

    @RequestMapping(value = "/getAllCourseByIsUnActive")
    public List<Course> getAllUnActiveCourse() {
        List<Course> notActiveCourseList = courseService.getAllUnActiveCourse();
        return notActiveCourseList;
    }



    @RequestMapping(value = "/getCourseLatestRow")
    public List<Course> getCourseLatestRow() {
        List<Course> courseLatestRowList = courseService.getCourseLatestRow();
        return courseLatestRowList;
    }
    @RequestMapping(value = "/getCourseLatestUpdated")
    public List<Course> getCourseLatestUpdated() {
        List<Course> courseLatestUpdatedList = courseService.getCourseLatestUpdated();
        return courseLatestUpdatedList;
    }


    @RequestMapping(value = "/getCourseCreatedAfterDate",method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String date) throws ParseException {
        List<Course> CourseCreatedAfterDate = courseService.getCourseCreatedAfterDate(date);
        return CourseCreatedAfterDate;
    }
    @RequestMapping(value = "setDeleteById",method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id)throws ParseException {
        courseService.setDeleteById(id);
    }

    @RequestMapping(value = "/deleteAllCourse")
    public void deleteAllCourse(){
        courseService.deleteAllCourse();
    }



}
