package com.kavanant.codesystem.icd10;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Icd10CodeRepository extends JpaRepository<Icd10Code, Integer> {

	@Query(value = "select * from icd10_codes where ShortDesc like %:codeOrShort% or ICDCode like %:codeOrShort%", nativeQuery = true)
	public Page<Icd10Code> getIcdCodeByCodeOrShort(String codeOrShort, Pageable pageable);

	@Query(value = "select * from icd10_codes where ICDCode=:icdCode and VersionState='Valid'", nativeQuery = true)
	Optional<Icd10Code> getIcdByCodeAndVersionState(String icdCode);

}
