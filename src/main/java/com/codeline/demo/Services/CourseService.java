package com.codeline.demo.Services;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.School;
import com.codeline.demo.Models.Student;
import com.codeline.demo.Repositories.CourseInterface;
import com.codeline.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class CourseService {



        @Autowired
        CourseInterface courseInterface;

        @Autowired
        StudentInterface studentInterface;



        public List<Course> getAllCourse() {

                return courseInterface.getAllCourse();
        }
        public Course getCourseById(Integer id) {
                Course course = courseInterface.getCourseById(id);
                return course;

        }
        public Course getCourseByCourseName(String courseName) {
                Course course = courseInterface.getCourseByName(courseName);
                Integer courseId = course.getId();
                course = courseInterface.getCourseById(courseId);
                return course;
        }

        public List<Course> getAllActiveCourse(){
                return courseInterface.getAllActiveCourse();
        }

        public List<Course> getAllUnActiveCourse(){
                return courseInterface.getAllUnActiveCourse();
        }
        public Student getStudentById(Integer id) {
                Student student = studentInterface.getStudentById(id);
                return student;

        }

        public List<Course> getCourseLatestRow(){
                return courseInterface.getCourseLatestRow();
        }

        public List<Course> getCourseLatestUpdated(){
                return courseInterface.getCourseLatestUpdated();
        }

        public List<Course> getCourseCreatedAfterDate(String date) throws ParseException{
                DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                Date UpdateDate= formatter.parse(date);
                return courseInterface.getCourseCreatedAfterDate();
        }

        public void deleteAllCourse() {
                courseInterface.deleteAllCourse();
        }
        public void setDeleteById(Integer id) throws ParseException {
                Course course = courseInterface.setDeleteById(id);
                course.setIsActive(true);
                courseInterface.save(course);
        }
//        public void updateCourse(Integer id, String name, Boolean isActive) {
//                Course course = courseInterface.getCourseById(id);
//                course.setName(name);
//                course.setCreatedDate(new Date());
//                course.setUpdatedDate(new Date());
//                course.setIsActive(isActive);
//                courseRepository.save(course);
//        }

}
