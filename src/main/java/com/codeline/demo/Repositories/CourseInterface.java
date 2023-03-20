package com.codeline.demo.Repositories;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.School;
import com.codeline.demo.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;



@Repository
    public interface CourseInterface extends CrudRepository<Course, Integer> {
    @Query("SELECT c from Course c")
    List<Course> getAllCourse();


    @Query(value = "Select * from Course where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Course> getCourseByUpdatedDate(String UpdatedDate);

    @Query("SELECT s from Course s where s.id= :courseId")
    Course getCourseById(@Param("courseId") Integer id);

    @Query("SELECT c from Course c where c.name= :courseName")
    Course getCourseByName(@Param("courseName") String course_name);

    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourse();

    @Query(value = "SELECT c from Course c where c.isActive = false")
    List<Course> getAllUnActiveCourse();


    @Query("SELECT s from Student s where s.id= :studentId")
    Student getStudentById(@Param("studentId") Integer id);

    @Query(value = "SELECT c from Course c where c.id = (SELECT Max(c.id) FROM Course c)")
    List<Course> getCourseLatestRow();

    @Query(value = "SELECT c from Course c  where c.updateDate = (SELECT MAX(c.updateDate) FROM Course c)")
    List<Course> getCourseLatestUpdated();

    @Query("SELECT c from Course c where c.createDate >= :createdDate")
    List<Course> getCourseCreatedAfterDate();

    @Query(value = "Select * from Course where created_date like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
    List<Course> getCourseByCreatedDate(String createdDate);
    @Query(value="update Course s set s.isActive=false where s.id=:id")
    Course setDeleteById(@Param("id")Integer id);
    @Modifying
    @Transactional
    @Query(value = "Update Course co Set co.isActive = false")
    void deleteAllCourse();
    @Query(value = "select c from Course c where c.createDate >=  :createdDate")
    List<Course> deleteAllCoursesCreatedAfterDate(Date createdDate);



//} @Query("SELECT c from Course c where c.createdDate >= :createdDate")
//List<Course> getSchoolCreatedAfterDate(Date createdDate);

}