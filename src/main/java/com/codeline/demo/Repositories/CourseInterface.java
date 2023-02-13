package com.codeline.demo.Repositories;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
    public interface CourseInterface extends CrudRepository<Course, Integer> {
        @Query("SELECT c from Course c")
        List<Course> getAllCourse();


    @Query("SELECT s from Course s where s.id= :courseId")
    Course getCourseById(@Param("courseId") Integer id);


}
