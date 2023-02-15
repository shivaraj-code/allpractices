package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.CPT;

@Repository
public interface CPTRepository extends JpaRepository<CPT, Integer> {

	//@Query(value = "(select * from cpt  where (code like %:code% OR short_name like %:code% OR description like %:code% OR created_by like %:code% OR last_modified_by like %:code% OR created_date like %:code% OR last_modified_date like %:code%))", nativeQuery = true)
	//List<CPT> getCPTByCode(String code);

	// @Query(value = "select * from cpt_short where ShortName like
	// %:codeOrShortOrDesc% or Code like %:codeOrShortOrDesc% or Description like
	// %:codeOrShortOrDesc% ", nativeQuery = true)
	//public Page<CPT> getAllCptByPagination(String getAllCptByPagination, Pageable pageable);
	
	@Query(value = "select * from cpt  where code like %:code% OR short_name like %:code% OR description like %:code% ", nativeQuery = true)
	Page<CPT> getCPTByCode(String code, Pageable pageable);

	@Query(value = "select * from cpt where short_name like %:short_name%", nativeQuery = true)
	List<CPT> getCPTByShortName(String short_name);

	@Query(value = "select * from cpt where description like %:description%", nativeQuery = true)
	List<CPT> getCPTByDescription(String description);

	
	@Query(value = "select * from cpt where created_by like %:created_by%", nativeQuery = true)
	List<CPT> getCreatedBy(String created_by);

	@Query(value = "select * from cpt where last_modified_by like %:last_modified_by%", nativeQuery = true)
	List<CPT> getModifiedBy(String last_modified_by);

	@Query(value = "select * from cpt where created_date like %:created_date%", nativeQuery = true)
	List<CPT> getcreatedByDate(String created_date);

	@Query(value = "select * from cpt where last_modified_date like %:last_modified_date%", nativeQuery = true)
	List<CPT> getModifiedByDate(String last_modified_date);

	@Query(value = "select * from cpt where code=:code and version_state='Valid'", nativeQuery = true)
	Optional<CPT> getCPTByCodeAndStatus(String code);

	@Query(value = "select * from cpt where pageable like %:pageable%", nativeQuery = true)
	List<CPT> getAllCptByPagination(Pageable pageable);

	
	/*
	 * @Query(value = "select * from cpt where code=:code and status='Y'",
	 * nativeQuery = true) Optional<CPT> getCPTByCodeAndStatusNo(String code);
	 */
	// @Query("select a from CPT a where a.code='Y'")
	// List<CPT> getCodeByCodeAndRetiredNo(String code);
}

//OR created_by %:code% OR last_modified_by %:code%

/*
 * @Modifying
 * 
 * @Query("Update cpt set id=:id where code=:code") void updateCptCode(String
 * code);
 */

//@Query("select c from CPT c where c.status='Y'")
// List<CPT> findAllActiveRecords();


//ss
// @Query(value = "select * from cpt where short_name like %:short_name% or code
// like %:short_name% or created_by like %:short_name% or description like
// %short_name% ", nativeQuery = true)
// List<CPT> getCPTByShortName(String short_name);

//sss
// @Query(value = "select * from cpt where (code like %:code% OR short_name like
// %:code% OR description like %:code%) AND status='Y')", nativeQuery = true)
// List<CPT> getCPTByCode(String code);
