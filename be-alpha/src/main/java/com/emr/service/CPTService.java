package com.emr.service;

import java.util.List;

import com.emr.model.CPT;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CPTService {

	CPT addcpt(CPT cptRequest);

	List<CPT> getCPTs();

	CPT getCPTById(int id);

//	List<CPT> getCPTByCode(String code);

	List<CPT> getCPTByShortName(String short_name);

	List<CPT> getCPTByDescription(String description);

	void deleteCptById(int id);

	List<CPT> getCreatedBy(String created_by);

	List<CPT> getModifiedBy(String last_modified_by);

	List<CPT> getcreatedByDate(String created_date);

	List<CPT> getModifiedByDate(String last_modified_date);

	Page<CPT> getAllCptByPagination(Pageable pageable);

	CPT updateCpt( CPT cptCode);

	List<CPT> getCPTByCode(String code, Pageable pageable);

}