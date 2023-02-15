package com.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query(value="select * from student_table where student_Phone like %:student_Phone%", nativeQuery=true)
	Student getStudentByPhone(String student_Phone);

	@Query(value="select * from student_table where student_Mail like %:student_Mail%", nativeQuery =true)
	Student getStudentByMail(String student_Mail);
	
	@Query(value="select * from student_table where student_Name like %:student_Name%", nativeQuery=true)
	Student geStudentByName(String student_Name);
}
