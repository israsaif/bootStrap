package com.codeline.demo.Controllers;


import com.codeline.demo.Models.School;
import com.codeline.demo.Repositories.SchoolInterface;
import com.codeline.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.demo.Services.SchoolService;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    private SchoolInterface schoolInterface;


    @GetMapping
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        String slackMessageContent = "";
        for (School S : schools) {
            slackMessageContent += "the id is :" + S.getId() + "the name is:\t" + S.getName() + "\n";
        }
        if (!slackMessageContent.equals(""))
            slackClient.sendMessage(slackMessageContent);
        return schools;
    }


    @GetMapping(path = "/{id}")
    public School getSchoolById(@PathVariable(name = "id") Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        slackClient.sendMessage("the id is :" + school.getId() + "the name is:\t" + school.getName());
        return school;
    }

    @RequestMapping(value = "/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        slackClient.sendMessage("the id is :" + schoolName.getId() + "the name is:\t" + schoolName.getName());
        return schoolName;
    }

    @RequestMapping(value = "/getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        for (School S : activeSchoolsList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive());
        }
        return activeSchoolsList;
    }

    @RequestMapping(value = "/getAllSchoolByIsUnActive")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllUnActiveSchools();
        for (School S : notActiveSchoolsList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getIsActive());
        }
        return notActiveSchoolsList;
    }

    @RequestMapping(value = "/getSchoolLatestRow")
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        for (School S : schoolLatestRowList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive());
        }
        return schoolLatestRowList;
    }


    @RequestMapping(value = "/getSchoolLatestUpdated")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        for (School S : schoolLatestUpdatedList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getUpdateDate());
        }
        return schoolLatestUpdatedList;
    }

    @RequestMapping(value = "/getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getSchoolsByCreatedDate(createDate);
        for (School S : createdAfterDate) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getUpdateDate());
        }
        return createdAfterDate;
    }


    @RequestMapping(value = "/getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(String createDate) throws ParseException {
        List<School> getSchoolByCreatedDateVariable = schoolService.getSchoolCreatedAfterDate(createDate);
        for (School S : getSchoolByCreatedDateVariable) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getCreateDate());
        }
        return getSchoolByCreatedDateVariable;
    }


    @RequestMapping(value = "/getSchoolByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByUpdatedDateVariable(String UpdatedDate) throws ParseException {
        List<School> getSchoolByUpdatedDateVariable = schoolService.getSchoolByUpdatedDate(UpdatedDate);
        for (School S : getSchoolByUpdatedDateVariable) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getUpdateDate());
        }
        return getSchoolByUpdatedDateVariable;
    }

    //    @RequestMapping(value = "/getSchoolByNumberOfStudent", method = RequestMethod.POST)
    //    public School getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
    //        return schoolService.getSchoolByNumberOfStudent(numberOfStudent);
    //
    //    }

    @RequestMapping(value = "/deleteSchoolById")
    public void deleteSchoolById(Integer id) {
        schoolService.deleteSchoolById(id);
    }


    @DeleteMapping
    public void deleteAllSchool() {
        schoolService.deleteAllSchool();
    }

    @DeleteMapping(path = "/{name}")
    public void deleteBySchoolName(@PathVariable String name) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + name);
        schoolService.deleteBySchoolName(name);
    }

    @RequestMapping(value = "/deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByCreatedDate(@RequestParam String createdDate) {
        schoolService.deleteSchoolsByCreatedDate(createdDate);
    }

    @RequestMapping(value = "/deleteSchoolsByUpdatedDate ", method = RequestMethod.POST)
    public void deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) {
        schoolService.deleteSchoolsByUpdatedDate(updatedDate);
    }


    @RequestMapping(value = "/createSchool")
    public void createSchool(String name) {
        schoolService.createSchool(name);
    }

    @RequestMapping(value = "/updateSchool")
    public void updateSchool(@RequestParam Integer id, String name, Boolean isActive) {
        schoolService.updateSchool(id, name, isActive);
    }

    @RequestMapping(value = "/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());
    }

    @Autowired
    SlackClient slackClient;

}
