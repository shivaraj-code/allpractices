package com.kavanant.codesystem.cpt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kavanant.codesystem.util.ListUtils;

@Service
public class CptCodeServiceImpl implements CptCodeService {

	@Autowired
	CptCodeRepository cptCodeRepository;

	@Autowired
	CptCodeCategoryRepository cptCodeCategoryRepository;

	@Override
	public CptCode addCptCode(CptCode cptCode) {
		Optional<CptCode> existingCptCode = cptCodeRepository.getCptCodeByCodeAndVersionState(cptCode.getCode());

		if (existingCptCode.isPresent()) {
			return existingCptCode.get();
		} else {

			CptCode savedCpt = cptCodeRepository.save(cptCode);
			savedCpt.setRefId(savedCpt.getId());
			savedCpt.setOriginalRefId(savedCpt.getId());
			// savedCpt.setVersionState("VALID");
			return cptCodeRepository.save(savedCpt);
		}
	};

	@Override
	public Optional<CptCode> getCptCodeById(int id) {

		return cptCodeRepository.findById(id);
	}

	/*
	 * public Optional<CptCode> getCptCodeById(int id) {
	 * 
	 * return cptCodeRepository.findById(id); }
	 */
	@Override
	public CptCode updateCptCodeById(CptCode cptCode) {

		Optional<CptCode> existingCpt = cptCodeRepository.findById(cptCode.getId());

		existingCpt.ifPresent(existingCptCode -> {
			// Updating Existing Code
			existingCptCode.setVersionState("InValid");
			// existingCptCode.setRetired("Y");
			cptCodeRepository.save(existingCptCode);

			// Inserting Modified Code As New One
			cptCode.setRefId(existingCptCode.getId());
			cptCode.setOriginalRefId(existingCptCode.getOriginalRefId());
			cptCode.setVersionState("Valid");
			cptCode.setId(0);
			cptCodeRepository.save(cptCode);
			// System.out.println(cptCode.toString());
		});

		return cptCode;
	}

	@Override
	public List<CptCode> getCptCodeByCodeOrShortOrDesc(String shortName, Pageable pageable) {

		return cptCodeRepository.getCptCodeByCodeOrShortOrDesc(shortName, pageable).getContent();
	}

	@Override
	public List<CptCategory> getCptCodeByCodeOrShortOrDescWithCtg(String codeordesc, Pageable pageable) {

		List<CptCategory> cptList = cptCodeCategoryRepository.getCptCodeByCodeOrShortOrDescWithCtgUsingProc(codeordesc);
		return ListUtils.getPage(cptList, pageable.getPageNumber() + 1, pageable.getPageSize());

	}

	/*
	 * public Optional<CptCode> getCptCodeByCode(String code) {
	 * 
	 * return cptCodeRepository.getCptCodeByCode(code); }
	 */

	/*
	 * public List<CptCode> getCptCodeByDate(Date date,Pageable pageable) {
	 * 
	 * return cptCodeRepository.getCptCodeByDate(date,pageable).getContent(); }
	 */
	@Override
	public Page<CptCode> getAllCptCodesByPagination(Pageable pageable) {

		return cptCodeRepository.findAll(pageable);
	}

	/*
	 * public List<CptCode> getAllCptCodes() {
	 * 
	 * return cptCodeRepository.findAll(); }
	 */

}
