package com.kavanant.codesystem.cpt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Query(value = "CALL getcptcode(:codeorshort)", nativeQuery = true)
//List<CptCategory> getCptCodeByCodeOrShortWithCtg(String codeorshort);

/*
 * @Query(value = "CALL getcptcode(:codeordesc)", nativeQuery = true)
 * Page<CptCategory> getCptCodeByCodeOrShortOrDescWithCtg(String codeordesc,
 * Pageable pageable);
 */

public interface CptCodeCategoryRepository extends JpaRepository<CptCategory, Integer> {

	@Query(value = "CALL getCptCodeDetailsByCodeOrDesc(:codeordesc)", nativeQuery = true)
	public List<CptCategory> getCptCodeByCodeOrShortOrDescWithCtgUsingProc(String codeordesc);
	
}
