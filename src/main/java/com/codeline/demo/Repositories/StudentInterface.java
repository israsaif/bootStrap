package com.codeline.demo.Repositories;



import com.codeline.demo.Models.Mark;
import com.codeline.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInterface extends CrudRepository<Student, Integer> {

   @Query("SELECT s from Student s")

    List<Student> getAllStudent();

    @Query("SELECT s from Student s where s.id= :studentId")

    Student getStudentById(@Param("studentId") Integer id);

    @Query("SELECT s from Student s where s.name= :name")
    Student getStudentByName(@Param("name") String student_name);

 @Query(value = "SELECT st from Student st " +
         "WHERE st.school.id = :id ")
 List<Student> getSchoolById(@Param("id") Integer id);
}


