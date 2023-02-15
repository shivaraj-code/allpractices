package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Student;
import com.emr.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student strequest) {
		// TODO Auto-generated method stub
		return studentRepository.save(strequest);
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int stu_Id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(stu_Id).get();
	}

	@Override
	public Student updateStudent(int student_Id, Student studentrequest) {
		// TODO Auto-generated method stub
		Student std = studentRepository.getById(student_Id);

		std.setStudent_Name(studentrequest.getStudent_Name());
		std.setStudent_Mail(studentrequest.getStudent_Mail());
		std.setStudent_Phone(studentrequest.getStudent_Phone());
		return studentRepository.save(std);
	}

	@Override
	public void deleteStudent(int student_Id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(student_Id);
	}

	// GetbyPhone by through Student Repository

	@Override
	public Student getStudentByPhone(String student_Phone) {
		// TODO Auto-generated method stub
		System.out.println("Student Phone Number" + student_Phone);
		return studentRepository.getStudentByPhone(student_Phone);
	}

	@Override
	public Student getStudentByMail(String student_Mail) {
		// TODO Auto-generated method stub
		System.out.println("Student Mail" + student_Mail);
		return studentRepository.getStudentByMail(student_Mail);
	}

	@Override
	public Student getStudentByName(String student_name) {
		// TODO Auto-generated method stub
		System.out.println("Student Name"+student_name);
		return studentRepository.geStudentByName(student_name);
	}

}
