package com.codeline.demo.Repositories;


import com.codeline.demo.Models.Mark;
import com.codeline.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

    public interface SchoolInterface extends CrudRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query("SELECT s from School s where s.id= :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);

    @Query("SELECT s from School s where s.name= :schoolName")
    School getSchoolByName(@Param("schoolName") String school_name);


}
