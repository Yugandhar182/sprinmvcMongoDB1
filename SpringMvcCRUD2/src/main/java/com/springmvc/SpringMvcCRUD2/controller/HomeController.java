package com.springmvc.SpringMvcCRUD2.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.springmvc.SpringMvcCRUD2.entity.Studentdata;
import com.springmvc.SpringMvcCRUD2.service.StudentdataService;



@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StudentdataService studentdataService;



    @GetMapping
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView("studentsdata");
        try {
            Iterable<Studentdata> students = studentdataService.getAllStudents();
            modelAndView.addObject("students", students);
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception using a logger
            // Handle the exception appropriately
        }
        return modelAndView;
    }

    @GetMapping("/allstudents")
    @ResponseBody
    public   List<Studentdata>  getAllStudentsJson() {
    	
        try {
            // Return the list of all students as JSON
        	  // Get the updated list of all students from the service (including the newly saved one)
            List<Studentdata> allStudents = (List<Studentdata>) studentdataService.getAllStudents();
           System.out.println(allStudents);
           return  allStudents;
            
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
           
}
        
      


}
}


