package com.codeline.demo.Scheduled;


import com.codeline.demo.Models.School;
import com.codeline.demo.Repositories.SchoolInterface;
import com.codeline.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.demo.Services.SchoolService;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Component
@RequestMapping(value = "Scheduled")
public class ScheduledSlack {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;

    @Scheduled(cron = "0 5 * * * *")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        for (School S : activeSchoolsList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive());
        }
        return activeSchoolsList;
    }

    @Scheduled(cron = "0 5 * * * *")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllUnActiveSchools();
        for (School S : notActiveSchoolsList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getIsActive());
        }
        return notActiveSchoolsList;
    }

    @Scheduled(cron = "0 5 * * * *")
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        for (School S : schoolLatestRowList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive());
        }
        return schoolLatestRowList;
    }


    @Scheduled(cron = "0 5 * * * *")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        for (School S : schoolLatestUpdatedList) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getUpdateDate());
        }
        return schoolLatestUpdatedList;
    }

    @Scheduled(cron = "0 5 * * * *")
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getSchoolsByCreatedDate(createDate);
        for (School S : createdAfterDate) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getUpdateDate());
        }
        return createdAfterDate;
    }


    @Scheduled(cron = "0 5 * * * *")
    public List<School> getSchoolByCreatedDate(String createDate) throws ParseException {
        List<School> getSchoolByCreatedDateVariable = schoolService.getSchoolCreatedAfterDate(createDate);
        for (School S : getSchoolByCreatedDateVariable) {
            slackClient.sendMessage("the id is :" + S.getId() + "the name is:\t" + S.getName() + S.getIsActive() + S.getCreateDate());
        }
        return getSchoolByCreatedDateVariable;
    }






}
