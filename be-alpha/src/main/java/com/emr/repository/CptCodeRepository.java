package com.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.emr.model.CptCategory;

@Service
public interface CptCodeRepository extends JpaRepository<CptCategory, Integer>{

	
	@Query(value="call getCptCodeDetailsByCodeOrDesc(:codeordes)", nativeQuery=true)
	public List<CptCategory> getCptCodeDetailsByCodeOrDescWithCtgUsingProc(String codeordes);
}
