package com.codeline.demo.Services;

import com.codeline.demo.Models.School;
import com.codeline.demo.Models.Student;
import com.codeline.demo.Repositories.SchoolInterface;
import com.codeline.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class StudentServices {

    @Autowired
    StudentInterface studentInterface;
    @Autowired
    private SchoolInterface schoolInterface;

    public void addStudent() {

        Student student = new Student();
        student.setName("ISRA");
        student.setId(1);

        studentInterface.save(student);
    }


    public List<Student> getAllStudent() {

        return studentInterface.getAllStudent();
    }

    public void deleteStudentById(Integer Id) {

        Student StudentToDelete = studentInterface.findById(Id).get();
        studentInterface.delete(StudentToDelete);
    }

//    public List<Student> getStudentsBySchoolName(String schoolName){
//        School school = schoolInterface.getBySchoolName(schoolName);
//        Integer schoolId = school.getId();
//        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolId);
//        return studentList;
//    }

    public Student getStudentById(Integer id) {
        Student student = studentInterface.getStudentById(id);
        return student; //creating an empty course and returning it.

    }

    public Student getStudentByName(String student_name) {
        Student studentName = studentInterface.getStudentByName(student_name);
        return studentName;
    }
    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolInterface.getSchoolByName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentInterface.getSchoolById(schoolId);
        return studentList;
    }
    public List<Student> getAllActiveStudent(){
        return studentInterface.getAllActiveStudent();
    }

    public List<Student> getAllUnActiveStudent(){
        return studentInterface.getAllUnActiveStudent();
    }

}
