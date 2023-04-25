package com.codeline.demo.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CourseDTO {
    String courseName;
    String obtainedMarks;

    String gradeMark;

    public CourseDTO(String courseName, String obtainedMarks, String gradeMark) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.gradeMark = gradeMark;
    }
}
