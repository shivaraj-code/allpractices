package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Employee;
import com.emr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee empRequest) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empRequest);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(int id,Employee employeeDetails) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.getById(id);
		
		employee.setName(employeeDetails.getName());
		employee.setMobile(employeeDetails.getMobile());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeDetails(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByName(name);
	}

}
