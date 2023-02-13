package com.codeline.demo.Services;

import com.codeline.demo.Models.School;
import com.codeline.demo.Repositories.SchoolInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolInterface schoolInterface;

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
}
