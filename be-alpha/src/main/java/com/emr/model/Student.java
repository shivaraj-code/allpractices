package com.emr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "student_Id")
	private int student_Id;

	@Column(name = "student_Name")
	private String student_Name;

	@Column(name = "student_Mail")
	private String student_Mail;

	@Column(name = "student_Phone")
	private String student_Phone;

	@ManyToOne
	@JoinColumn(name = "class_Id_FK")
	private Class classvariable;

}
