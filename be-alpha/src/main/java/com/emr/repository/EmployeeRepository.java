package com.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	@Query(value="select * from employee_table where name like %:name%", nativeQuery=true)
	Employee getEmployeeByName(String name);

	//@Query("SELECT m FROM MedicinePostSyncResultsModel m WHERE m.ndc LIKE %:searchTerm% OR m.name LIKE %:searchTerm%")
	//Page<MedicinePostSyncResultsModel> getMedicinesVerificationSearch(@Param("searchTerm") String searchTerm, Pageable pageable);

}
