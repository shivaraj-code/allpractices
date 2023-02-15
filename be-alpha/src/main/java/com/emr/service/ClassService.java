package com.emr.service;

import java.util.List;

import com.emr.model.Class;

public interface ClassService {

	Class createClass(Class classrequest);
	
	List<Class> getClassDetails();
	
	Class getClassById(int class_Id);

	Class updateClass(int class_Id, Class classrequest);

	void deleteClass(int class_Id);

	
}
