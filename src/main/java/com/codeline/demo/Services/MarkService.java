package com.codeline.demo.Services;

import com.codeline.demo.Models.Mark;
import com.codeline.demo.Repositories.MarkInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {


        @Autowired
        MarkInterface markInterface;


        //function that gets all the school
        public List<Mark> getAllMarks() {

                return markInterface.getAllMarks();
        }

        public Mark getMarkById(Integer id) {
                Mark mark = markInterface.getMarkById(id);
                return mark;
        }
        public List<Mark> getAllActiveMark(){
                return markInterface.getAllActiveMark();
        }

        public List<Mark> getAllUnActiveMark(){
                return markInterface.getAllUnActiveMark();
        }



}