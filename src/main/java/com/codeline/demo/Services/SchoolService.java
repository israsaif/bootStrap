package com.codeline.demo.Services;

import com.codeline.demo.Models.School;
import com.codeline.demo.Repositories.SchoolInterface;
import com.codeline.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolInterface schoolInterface;
    @Autowired
    private StudentInterface studentInterface;

    public List<School> getAllSchools(){

        return schoolInterface.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolInterface.getSchoolById(id);
        return school;
    }
    public School getSchoolByName(String school_name) {
        School schoolName = schoolInterface.getSchoolByName(school_name);
        return schoolName;
    }
    public List<School> getAllActiveSchools(){
        return schoolInterface.getAllActiveSchools();
    }

    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolInterface.getSchoolById(id);
        school.setCreateDate(convertedDateFromStringToDateFormat);
        schoolInterface.save(school);
    }
    public List<School> getAllUnActiveSchools() {
        return schoolInterface.getAllUnActiveSchools();
    }
    public List<School> getSchoolLatestUpdated() {
        return schoolInterface.getSchoolLatestUpdated();
    }



    public List<School> getSchoolsByCreatedDate(String createdDate) {
        List<School> schools = schoolInterface.getSchoolsByCreatedDate(createdDate);
        return schools;
    }

    public List<School> getSchoolByUpdatedDate(String UpdatedDate) {
        List<School> schools = schoolInterface.getSchoolsByCreatedDate(UpdatedDate);
        return schools;
    }


//    public School getSchoolByNumberOfStudent(Integer numberOfStudent){
//        List<Integer> typesOfSchoolIdsInStudent = studentInterface.get
//                .getDistinctSchoolIdsFromStudent();
//        Integer schoolIdThatUserWants = 0;
//        for (Integer idOfSchool: typesOfSchoolIdsInStudent) {
//            Integer count = studentInterface.getCountOfStudentsBySchoolId(idOfSchool);
//            if(numberOfStudent == count) {
//                schoolIdThatUserWants = idOfSchool;
//                break;
//            }
//        }
//        School schoolThatUserWasLookingFor = schoolInterface.getSchoolById(schoolIdThatUserWants);
//        return schoolThatUserWasLookingFor;
//    }


    public void deleteSchoolById(Integer id) {
        School school = schoolInterface.getSchoolById(id);
        school.setIsActive(Boolean.FALSE);
        schoolInterface.save(school);
    }


    public void deleteAllSchool() {
        schoolInterface.deleteAllSchool();
    }

    public void deleteBySchoolName(String name) {
        School school = schoolInterface.getSchoolByName(name);
        school.setIsActive(Boolean.FALSE);
        schoolInterface.save(school);
    }


    public void deleteSchoolsByCreatedDate(String createdDate) {
        List<School> schools = schoolInterface.getSchoolsByCreatedDate(createdDate);
        schools.stream().forEach(create -> create.setIsActive(Boolean.FALSE));
        schoolInterface.saveAll(schools);
    }



    public void deleteSchoolsByUpdatedDate(String updatedDate) {
        List<School> school = schoolInterface.getSchoolByUpdatedDate(updatedDate);
        school.stream().forEach(update -> update.setIsActive(Boolean.FALSE));
        schoolInterface.saveAll(school);
    }
    public List<School> getSchoolLatestRow() {
        return schoolInterface.getSchoolLatestRow();
    }

    public void createSchool(String name) {
        School school = new School();
        school.setName(name);
        school.setCreateDate(new Date());
        school.setUpdateDate(new Date());
        school.setIsActive(Boolean.TRUE);
        schoolInterface.save(school);
    }

    public void updateSchool(Integer id, String name, Boolean isActive) {
        School school = schoolInterface.getSchoolById(id);
        school.setName(name);
        school.setCreateDate(new Date());
        school.setUpdateDate(new Date());
        school.setIsActive(isActive);
        schoolInterface.save(school);
    }

/////

    public List<School> getSchoolCreatedAfterDate(String createDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createDate);
        List<School> schools =schoolInterface.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return schools;
    }
}
