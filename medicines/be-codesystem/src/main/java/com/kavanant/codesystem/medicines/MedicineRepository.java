package com.kavanant.codesystem.medicines;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	@Query(value = " select * from medicines_new where Name like %:NDCorName% or NDC like %:NDCorName% ", nativeQuery = true)
	Page<Medicine> getNDCorName(String NDCorName, Pageable pageable);

	@Query(value = "select * from medicines_new where AIId=:aiid and VersionState='Validated'", nativeQuery = true)
	Optional<Medicine> getMedicineByCodeAndVersionState(int aiid);

	@Query(value = "select * from medicines_new where VersionState='InValid'", nativeQuery = true)
	List<Medicine> findAllInActiveRecords();

	//@Query("SELECT m FROM MedicinePostSyncResultsModel m WHERE m.ndc LIKE %:searchTerm% OR m.name LIKE %:searchTerm%")
	//Page<MedicinePostSyncResultsModel> getMedicinesVerificationSearch(@Param("searchTerm") String searchTerm, Pageable pageable);


}
