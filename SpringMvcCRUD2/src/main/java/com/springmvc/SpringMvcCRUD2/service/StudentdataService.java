package com.springmvc.SpringMvcCRUD2.service;



import com.springmvc.SpringMvcCRUD2.entity.Studentdata;

public interface StudentdataService {

 Iterable<Studentdata> getAllStudents() ;

Studentdata saveStudent(Studentdata studentdata);

void deleteStudentById(int id);
		
Studentdata updateStudent(Studentdata updatedStudent);	

}
