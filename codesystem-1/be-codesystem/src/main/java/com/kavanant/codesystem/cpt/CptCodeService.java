package com.kavanant.codesystem.cpt;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CptCodeService {

	Page<CptCode> getAllCptCodesByPagination(Pageable pageable);

	CptCode addCptCode(CptCode cptCode);

	CptCode updateCptCodeById(CptCode cptCode);

	List<CptCategory> getCptCodeByCodeOrShortOrDescWithCtg(String codeordesc, Pageable pageable);

	List<CptCode> getCptCodeByCodeOrShortOrDesc(String codeOrShortOrDesc, Pageable pageable);

	Optional<CptCode> getCptCodeById(int id);

	
	
}
