package com.springmvc.SpringMvcCRUD2.service.impl;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.SpringMvcCRUD2.entity.Studentdata;
import com.springmvc.SpringMvcCRUD2.repository.StudentdataRepository;
import com.springmvc.SpringMvcCRUD2.service.StudentdataService;

@Service
public class StudentdataServiceImpl implements StudentdataService {

    @Autowired
    private StudentdataRepository studentdataRepository;

    @Override
    public Iterable<Studentdata> getAllStudents() {
        try {
            return studentdataRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception using a logger
            // Handle the exception appropriately
            return null; // or throw a custom exception
        }
    }

    
    
    //Add student
    
	@Override
	public Studentdata saveStudent(Studentdata studentdata) {
	try {
		return studentdataRepository.save(studentdata);
	}
	catch(Exception e) {
		
	e.printStackTrace();
	return null;
	}
	}
	
	
//Delete Student
	 @Override
	    public void deleteStudentById(int id) {
	        // Implementation to delete a student by ID
	        studentdataRepository.deleteById(id);
	    }
	 
	 
	 //Edit student

	@Override
	public Studentdata updateStudent(Studentdata updatedStudent) {
		
	Optional<Studentdata>  existingStudentOptional= studentdataRepository.findById(updatedStudent.getId());
	
	if(existingStudentOptional.isPresent()) {
		 // If the student exists, update the data
		  Studentdata existingStudent = existingStudentOptional.get();
          existingStudent.setFirstname(updatedStudent.getFirstname());
          existingStudent.setLastname(updatedStudent.getLastname());
          existingStudent.setEmail(updatedStudent.getEmail());
          existingStudent.setMobile(updatedStudent.getMobile());
          
          return studentdataRepository.save(existingStudent);
		
	}else {
		return null;
	}
	
	}
	
}
