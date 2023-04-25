//package com.codeline.demo.Report;
//
//
//import com.codeline.demo.DTO.MarkDTO;
//import com.codeline.demo.DTO.StudentDTO;
//import com.codeline.demo.Models.Mark;
//import com.codeline.demo.Models.Student;
//import com.codeline.demo.Repositories.MarkInterface;
//import com.codeline.demo.Repositories.SchoolInterface;
//import com.codeline.demo.Repositories.StudentInterface;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class SecondReport {
//
//
//    @Autowired
//    MarkInterface markInterface;
//
//    @Autowired
//    public static final String pathToReports = "C:\\Users\\User006\\Downloads\\Report";



//
//    public String CourseReport() throws FileNotFoundException, JRException {
//        List<Mark> markList = markInterface.getAllMarks();
//        List<MarkDTO> markDTOArrayList = new ArrayList<>();
//        for (Mark markListVariable : markList){
//            String courseName = markListVariable.getId();
//            String obtainedMarks = markListVariable.getObtainedMarks();
//            String grade = markListVariable.getGrade();
//            MarkDTO markDTO = new MarkDTO(courseName, obtainedMarks, grade);
//            markDTOArrayList.add(markDTO);
//            markListVariable markDTO = new markListVariable( courseName,obtainedMarks,gradeMark);
//            marksList.add(MarkDTO);
//        }
//        File file = new File("C:\\Users\\User006\\IdeaProjects\\demo\\src\\main\\resources\\Course.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
//        Map<String, Object> paramters = new HashMap<>();
//        paramters.put("CreatedBy", "Isra");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\AllCourseForAllMarks.pdf");
//        return "Report generated : " + pathToReports+"\\AllCourseForAllMarks.pdf";
//    }
//
//
//}
