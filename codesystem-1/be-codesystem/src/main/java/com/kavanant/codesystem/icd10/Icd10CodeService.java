package com.kavanant.codesystem.icd10;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface Icd10CodeService {

	Page<Icd10Code> getAllIcdCodesByPagination(Pageable pageable);

	List<Icd10Code> getIcdCodeByCodeOrShort(String codeOrShort, Pageable pageable);

	Icd10Code addICDCode(Icd10Code icdCode);

	Icd10Code updateICDCodeById(Icd10Code icdCode);

	

}
