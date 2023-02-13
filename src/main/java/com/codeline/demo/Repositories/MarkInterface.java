package com.codeline.demo.Repositories;

import com.codeline.demo.Models.Course;
import com.codeline.demo.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkInterface extends CrudRepository<Mark, Integer>  {


@Query("SELECT m from Mark m")
List<Mark> getAllMarks();


    @Query("SELECT m from Mark m where m.id= :markId")
    Mark getMarkById(@Param("markId") Integer id);

    }

