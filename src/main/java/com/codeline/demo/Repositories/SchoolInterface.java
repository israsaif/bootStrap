package com.codeline.demo.Repositories;


import com.codeline.demo.Models.Mark;
import com.codeline.demo.Models.School;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository

    public interface SchoolInterface extends CrudRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query("SELECT s from School s where s.id= :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);



    @Query("SELECT s from School s where s.name= :schoolName")
    School getSchoolByName(@Param("schoolName") String school_name);

    @Query(value = "SELECT sch from School sch where sch.isActive = true")
    List<School> getAllActiveSchools();
    @Query(value = "SELECT sch from School sch where sch.isActive = false")
    List<School> getAllUnActiveSchools();
    @Query(value = "SELECT sch from School sch where sch.id = (SELECT Max(sch.id) FROM School sch)")
    List<School> getSchoolLatestRow();

    @Query(value = "SELECT sch from School sch where sch.updateDate = (SELECT MAX(sch.updateDate) FROM School sch)")
    List<School> getSchoolLatestUpdated();

    @Query("SELECT sch from School sch where sch.createDate >= :createdDate")
    List<School> getSchoolCreatedAfterDate(@Param("createdDate") Date createDate);

    @Modifying // enhance the query annotation.
    @Transactional // Use Method for database transaction, allows us to set propagation, isolation, timeout, read-only,
    // and rollback conditions and specify the transaction manager.
    @Query(value = "Update School sch Set sch.isActive = false")
    void deleteAllSchool();

    @Query(value = "Select * from school where createDate like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
    List<School> getSchoolsByCreatedDate(String createdDate);

    @Query(value = "Select * from school where updateDate like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
    List<School> getSchoolByUpdatedDate(String UpdatedDate);

}
