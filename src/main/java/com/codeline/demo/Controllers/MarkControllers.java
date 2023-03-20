package com.codeline.demo.Controllers;


import com.codeline.demo.Models.Mark;
import com.codeline.demo.Services.MarkService;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkControllers {

@Autowired

MarkService markService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)

    public List<Mark> getAllMarks() {
        List<Mark> mark = markService.getAllMarks();

        return mark;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Mark getMarkById (@RequestParam Integer markId) {

        Mark mark = markService.getMarkById(markId);
        return mark;
    }
    @RequestMapping(value = "/getAllMarkByIsActive")
    public List<Mark> getAllActiveMark() {
        List<Mark> activeMarkList = markService.getAllActiveMark();
        return activeMarkList;
    }

    @RequestMapping(value = "/getAllMarkByIsUnActive")
    public List<Mark> getAllUnActiveMark() {
        List<Mark> notActiveMarkList = markService.getAllUnActiveMark();
        return notActiveMarkList;
    }
    @Autowired
    SlackClient slackClient;
}
