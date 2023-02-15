package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Class;
import com.emr.repository.ClassRepository;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassRepository classRepository;

	@Override
	public Class createClass(Class classrequest) {
		// TODO Auto-generated method stub
		return classRepository.save(classrequest);
	}

	@Override
	public List<Class> getClassDetails() {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}

	@Override
	public Class getClassById(int class_Id) {
		// TODO Auto-generated method stub
		return classRepository.findById(class_Id).get();
	}

	@Override
	public Class updateClass(int class_Id, Class classrequest) {
		// TODO Auto-generated method stub
		Class cls = classRepository.getById(class_Id);

		cls.setClass_Name(classrequest.getClass_Name());
		return classRepository.save(cls);
	}

	@Override
	public void deleteClass(int class_Id) {
		// TODO Auto-generated method stub
		classRepository.deleteById(class_Id);
	}

	/*
	 * // Post through Controller
	 * 
	 * @Override public Class createclass(Class classrequest) { // TODO
	 * Auto-generated method stub return classRepository.save(classrequest); }
	 * 
	 * // Get through Controller
	 * 
	 * @Override public List<Class> getClassDetails() { // TODO Auto-generated
	 * method stub return classRepository.findAll(); }
	 * 
	 * // GetById through Controller
	 * 
	 * @Override public Class getclassbyid(int class_Id, Class classData) { // TODO
	 * Auto-generated method stub return classRepository.findById(class_Id).get(); }
	 * 
	 * // Delete through Controller
	 * 
	 * @Override public void deleteclass(int class_Id) { // TODO Auto-generated
	 * method stub classRepository.deleteById(class_Id); }
	 * 
	 * @Override public Class getclassbyid(int class_Id) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * 
	 * 
	 * 
	 * // GetbyId through Class-Repository
	 * 
	 * @Override public Class getclassbyid(int class_Id, Class classData) { // TODO
	 * Auto-generated method stub Class cl = classRepository.getById(class_Id);
	 * cl.setClass_Name(classData.getClass_Name()); return classRepository.save(cl);
	 * }
	 * 
	 * 
	 * 
	 * // GetbyId through Class-Repository
	 * 
	 * @Override public Class getClassById(int class_Id) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * // Delete through Class-Repository
	 * 
	 * @Override public void deleteClassById(int class_Id) { // TODO Auto-generated
	 * method stub classRepository.deleteById(class_Id); }
	 */

}
