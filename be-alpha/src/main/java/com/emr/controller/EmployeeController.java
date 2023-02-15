
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

import com.emr.model.Employee;
import com.emr.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping( "/welcome" )
	   public String echo() {
	      return "Welcome to My World....!";
	   }
	
	@PostMapping("/employee/add")
	public ResponseEntity<String> createEmployee(@RequestBody Employee empRequest) {
		
		Employee employee = employeeService.createEmployee(empRequest);

		return ResponseEntity.status(201).body("Employee Created Successfully with Id "+employee.getId());
	}
	
	@GetMapping("/employee/list")
	public List<Employee> getEmployees() {
		
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employee/list/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/employee/edit/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeService.updateEmployee(id, employeeDetails);

		return ResponseEntity.status(201).body("Employee Details updated Successfully with Id " + employee.getId());
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable int id){
		employeeService.deleteEmployeeDetails(id);
		return ResponseEntity.status(200).body("Employee Details Deleted Successfully...");
	}
	
	@GetMapping("/employeename")
	public Employee getEmployeeByName(@RequestParam String name) {
		return employeeService.getEmployeeByName(name);
	}
	
}
