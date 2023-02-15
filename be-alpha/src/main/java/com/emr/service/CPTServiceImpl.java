package com.emr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.CPT;
import com.emr.model.CptCategory;
import com.emr.repository.CPTRepository;
import com.emr.repository.CptCodeRepository;

@Service
public class CPTServiceImpl implements CPTService {
	@Autowired
	CPTRepository cptRepository;

	@Autowired
	CptCodeRepository cptcoderepository;

	@Override
	public CPT addcpt(CPT cptRequest) {
		// TODO Auto-generated method stub
		Optional<CPT> cpt = cptRepository.getCPTByCodeAndStatus(cptRequest.getCode());
		if (cpt.isPresent()) {
			return cpt.get();
		} else {

			CPT savedcpt = cptRepository.save(cptRequest);
			// savedcpt.setRefId(savedcpt.getId());
			savedcpt.setOriginalRefId(savedcpt.getId());
			return cptRepository.save(cptRequest);
		}
	}

	@Override
	public List<CPT> getCPTs() {
		// TODO Auto-generated method stub
		return cptRepository.findAll();
		// findAllActiveRecords
	}

	@Override
	public CPT getCPTById(int id) {
		// TODO Auto-generated method stub
		return cptRepository.findById(id).get();
	}

	@Override
	public List<CPT> getCPTByShortName(String short_name) {
		// TODO Auto-generated method stub
		System.out.println("ShortName" + short_name);
		return cptRepository.getCPTByShortName(short_name);
	}

	@Override
	public List<CPT> getCPTByDescription(String description) {
		// TODO Auto-generated method stub
		return cptRepository.getCPTByDescription(description);
	}

	@Override
	public List<CPT> getCreatedBy(String created_by) {
		// TODO Auto-generated method stub
		return cptRepository.getCreatedBy(created_by);
	}

	@Override
	public List<CPT> getModifiedBy(String last_modified_by) {
		// TODO Auto-generated method stub
		return cptRepository.getModifiedBy(last_modified_by);
	}

	@Override
	public List<CPT> getcreatedByDate(String created_date) {
		// TODO Auto-generated method stub
		return cptRepository.getcreatedByDate(created_date);
	}

	@Override
	public List<CPT> getModifiedByDate(String last_modified_date) {
		// TODO Auto-generated method stub
		return cptRepository.getModifiedByDate(last_modified_date);
	}

	/*
	 * @Override public CPT updateCpt(int id, CPT cptCode) { Optional<CPT>
	 * existingCpt = cptRepository.findById(cptCode.getId());
	 * existingCpt.ifPresent(existingCPT -> {
	 * existingCPT.setVersionState("Invalid"); cptRepository.save(existingCPT);
	 * cptCode.setOriginalRefId(existingCPT.getOriginalRefId());
	 * cptCode.setRefId(existingCPT.getId()); cptCode.setVersionState("Valid");
	 * cptCode.setId(0); cptRepository.save(cptCode); }); return cptCode; }
	 */

	@Override
	public CPT updateCpt(CPT cptCode) {
		CPT existingCpt = cptRepository.getById(cptCode.getId());

		CPT latest = null;
		if (existingCpt != null) {
			existingCpt.setVersionState("Invalid");
			cptRepository.save(existingCpt);

			CPT cpt = new CPT();
			cpt.setRefId(existingCpt.getId());
			cpt.setOriginalRefId(existingCpt.getOriginalRefId());
			cpt.setCode(cptCode.getCode());
			cpt.setDescription(cptCode.getDescription());
			cpt.setIshcpcs(cptCode.getIshcpcs());
			cpt.setShortName(cptCode.getShortName());

			latest = cptRepository.save(cpt);
		}
		return latest;
	}

	@Override
	public void deleteCptById(int id) {
		// TODO Auto-generated method stub
		cptRepository.deleteById(id);
	}

	@Override
	public Page<CPT> getAllCptByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.findAll(pageable);
	}

	@Override
	public List<CPT> getCPTByCode(String code, Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.getCPTByCode(code, pageable).getContent();
	}

	public List<CptCategory> getCptCodeByCodeOrShortOrDescWithCtg(String codeordes) {
		return cptcoderepository.getCptCodeDetailsByCodeOrDescWithCtgUsingProc(codeordes);
	}

	/*
	 * @Override public CPT updateCpt(int id, CPT cptcode) { // TODO Auto-generated
	 * method stub Optional<CPT> existingCpt =
	 * cptRepository.getCPTByCodeAndStatus(cptcode.getCode());
	 * existingCpt.ifPresent(existingCptCode -> { existingCptCode.setStatus('N');
	 * cptRepository.save(existingCptCode); }); cptcode.setId(0); return
	 * cptRepository.save(cptcode); }
	 */
	/*
	 * @Override public Page<CPT> getAllCPTPagination(Pageable pageable) { // TODO
	 * Auto-generated method stub return cptRepository.findAll(pageable); }
	 */

	/*
	 * @Override public CPT updateCpt(int id, CPT cptcode) { // TODO Auto-generated
	 * method stub CPT cpt = cptRepository.getById(id);
	 * cpt.setCode(cptcode.getCode()); cpt.setShortName(cptcode.getShortName());
	 * cpt.setDescription(cptcode.getDescription());
	 * cpt.setIshcpcs(cptcode.getIshcpcs()); cpt.setStatus(cptcode.getStatus());
	 * cpt.setCreatedBy(cptcode.getCreatedBy());
	 * cpt.setCreatedDate(cptcode.getCreatedDate());
	 * cpt.setLastModifiedBy(cptcode.getLastModifiedBy());
	 * cpt.setLastModifiedBy(cptcode.getLastModifiedBy());
	 * 
	 * return cptRepository.save(cpt); }
	 */

	/*
	 * @Override public Page<CPT> getCPTPagination(Integer pageNumber, Integer
	 * pageSize, String sort) { Pageable pageable = null; if (sort != null) { //
	 * with sorting pageable = PageRequest.of(pageNumber, pageSize,
	 * Sort.Direction.ASC, sort); } else { // without sorting pageable =
	 * PageRequest.of(pageNumber, pageSize); } return
	 * cptRepository.findAll(pageable); }
	 */

}
/*
 * public Optional<CPT> updateCptByCode(CPT cptcode) {
 * cptRepository.findById(cptcode.getId()).ifPresent(modifiedCPT -> { //
 * modifiedCPT.setIshcpcs(cptcode.getIshcpcs());
 * modifiedCPT.setStatus(cptcode.getStatus()); //
 * modifiedCPT.setCreatedBy(cptcode.getCreatedBy()); //
 * modifiedCPT.setCreatedDate(cptcode.getCreatedDate()); //
 * modifiedCPT.setLastModifiedBy(cptcode.getLastModifiedBy()); //
 * modifiedCPT.setLastModifiedBy(cptcode.getLastModifiedBy());
 * cptRepository.save(modifiedCPT); }); return
 * cptRepository.findById(cptcode.getId()); }
 */
/*
 * @Override public CPT getCPTByShortName(String short_name) { // TODO
 * Auto-generated method stub System.out.println("short_name" + short_name);
 * return cptRepository.getCPTByShortName(short_name); }
 */

/*
 * @Override public Page<CPT> getCPTPagination(Integer pageNumber, Integer
 * pageSize, String sort) { Pageable pageable = null; if (sort != null) { //
 * with sorting pageable = PageRequest.of(pageNumber, pageSize,
 * Sort.Direction.ASC, sort); } else { // without sorting pageable =
 * PageRequest.of(pageNumber, pageSize); } return
 * cptRepository.findAll(pageable); }
 */
