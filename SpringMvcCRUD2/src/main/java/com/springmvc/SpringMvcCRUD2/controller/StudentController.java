package com.springmvc.SpringMvcCRUD2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.SpringMvcCRUD2.entity.Studentdata;
import com.springmvc.SpringMvcCRUD2.service.StudentdataService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentdataService studentdataService;
	
	@PostMapping("/addstudent")
	@ResponseBody
	public Studentdata  addStudent(@RequestBody Studentdata  studentdata) {
		
		try {
			return studentdataService.saveStudent(studentdata);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/deleteStudent/{id}")
	public ModelAndView deleteStudent(@PathVariable int id , ModelAndView modelAndView) {
		try {
			 // Delete the student by ID
			System.out.println(id);
			 studentdataService.deleteStudentById(id);
			  // Get the updated list of all students
		       List<Studentdata> allStudents = (List<Studentdata>) studentdataService.getAllStudents();
		       // Set the updated list of students in the ModelAndView
		       
		       modelAndView.addObject("students" , allStudents);
		       System.out.println(allStudents);
		       
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		 // Set the view name in the ModelAndView
		modelAndView.setViewName("studentsdata");
		return modelAndView;
	}

    @PostMapping("/updateStudent/{id}")
    @ResponseBody
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Studentdata updatedStudent) {
        try {
            // Set the ID of the updated student
            updatedStudent.setId(id);

            // Update the student data using the service
            studentdataService.updateStudent(updatedStudent);

            // Get the updated list of all students
            List<Studentdata> allStudents = (List<Studentdata>) studentdataService.getAllStudents();

            return ResponseEntity.ok(allStudents); // Return the updated list of students

        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception using a logger
            // Handle the exception appropriately, e.g., return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: " + e.getMessage());
        }
    }
   
	

}
