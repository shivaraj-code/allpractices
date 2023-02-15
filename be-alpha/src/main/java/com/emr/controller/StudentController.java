package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Student;
import com.emr.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/studentwelcome")
	public String nitin() {
		return "Welcome to MY World..Student..";
	}

	@PostMapping("/student/add")
	public ResponseEntity<String> createStudent(@RequestBody Student strequest) {

		Student stu = studentService.createStudent(strequest);

		return ResponseEntity.status(201)
				.body("Students Record created successfully with student Id" + stu.getStudent_Id());
	}
	
	@GetMapping("/student/list")
	public List<Student> getStudent() {
		return studentService.getStudent();
	}

	@GetMapping("/student/list/{student_Id}")
	public Student getStudentById(@PathVariable int student_Id) {
		return studentService.getStudentById(student_Id);
	}
	
	@PutMapping("/student/update/{student_Id}")
	public ResponseEntity<String> updateStudent(@PathVariable int student_Id, @RequestBody Student studentrequest) {

		Student st = studentService.updateStudent(student_Id, studentrequest);
		return ResponseEntity.status(201)
				.body("Student Record Updated Successfully with student Id" + st.getStudent_Id());
	}
	
	@DeleteMapping("/student/delete/{student_Id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int student_Id) {
		studentService.deleteStudent(student_Id);
		return ResponseEntity.status(200).body("Student Record Deleted Successfully with Student Id...");
	}
	
	@GetMapping("/studentphone")
	public Student getStudentByPhone(@RequestParam String student_phone) {
		return studentService.getStudentByPhone(student_phone);
	}
	
	@GetMapping("/studentmail")
	public Student getStudentByMail(@RequestParam String student_mail) {
		return studentService.getStudentByMail(student_mail);
	}
	
	@GetMapping("/studentname")
	public Student getStudentByName(@RequestParam String student_name) {
		return studentService.getStudentByName(student_name);
	}
}
