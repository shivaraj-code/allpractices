package com.emr.service;

import java.util.List;

import com.emr.model.Student;

public interface StudentService {

	Student createStudent(Student strequest);

	List<Student> getStudent();

	Student getStudentById(int stu_Id);

	Student updateStudent(int student_Id, Student studentrequest);

	void deleteStudent(int student_Id);

	Student getStudentByPhone(String student_phone);

	Student getStudentByMail(String student_mail);

	Student getStudentByName(String student_name);

}
