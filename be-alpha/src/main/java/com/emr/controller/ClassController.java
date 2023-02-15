package com.emr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.emr.model.Class;
import com.emr.service.ClassService;

@RestController
public class ClassController {

	@Autowired
	ClassService calssService;

	@RequestMapping("/classwelcome")
	public String navin() {
		return "Welcome to MY World..Class..";
	}

	@PostMapping("/class/add")
	public ResponseEntity<String> createClass(@RequestBody Class classrequest) {

		Class cls = calssService.createClass(classrequest);

		return ResponseEntity.status(201).body("Classes Record created successfully with class Id" + cls.getClass_Id());
	}

	
	  @GetMapping("/class/list")
	  public List<Class> getClassDetails(){
		  return calssService.getClassDetails(); }
	 

	@GetMapping("/class/list/{class_Id}")
	public Class getClassById(@PathVariable int class_Id) {
		return calssService.getClassById(class_Id);
	}
	
	@PutMapping("/class/update/{class_Id}")
	public ResponseEntity<String> updateClass(@PathVariable int class_Id, @RequestBody Class classrequest){
		Class cls=calssService.updateClass(class_Id, classrequest);
		return ResponseEntity.status(201).body("Class Details Updated Successfully with Class Id"+cls.getClass_Id());
	}

	@DeleteMapping("/class/delete/{class_Id}")
	public ResponseEntity<String> deleteClass(@PathVariable int class_Id){
		calssService.deleteClass(class_Id);
		return ResponseEntity.status(200).body("Class Record Deleted Successfully With Class Id"+class_Id);
	}
	
}
