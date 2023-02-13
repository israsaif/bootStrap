package com.codeline.demo.Services;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Repositories.CourseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {



        @Autowired // create instance, and then it can be used in all the program
        CourseInterface courseInterface;


        //function that gets all the school
        public List<Course> getAllCourse() {
            return courseInterface.getAllCourse();
        }
        public Course getCourseById(Integer id) {
                Course course = courseInterface.getCourseById(id);
                return course;

        }
}
