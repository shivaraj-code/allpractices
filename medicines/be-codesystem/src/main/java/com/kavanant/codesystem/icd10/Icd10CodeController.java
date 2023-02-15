package com.kavanant.codesystem.icd10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Icd10CodeController {

	@Autowired
	Icd10CodeService icd10CodeService;

	@GetMapping(path = "/icdcode/pagination")
	public ResponseEntity<List<Icd10Code>> getAllIcdCodesByPagination(@RequestParam Integer pageSize,
			@RequestParam Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Icd10Code> icdCodes = icd10CodeService.getAllIcdCodesByPagination(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Icd10Code>>(icdCodes.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping(path = "/icdcode/search")
	public ResponseEntity<List<Icd10Code>> getIcdCodeByCodeOrShort(@RequestParam String codeOrShort,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		List<Icd10Code> icdCodeResponse = icd10CodeService.getIcdCodeByCodeOrShort(codeOrShort, pageable);
		return new ResponseEntity<>(icdCodeResponse, headers, HttpStatus.OK);

	}

	@PostMapping("/icdcode")
	public ResponseEntity<Icd10Code> addICDCode(@RequestBody Icd10Code icdCode) {

		Icd10Code icdCodeResponse = icd10CodeService.addICDCode(icdCode);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Icd10Code>(icdCodeResponse, headers, HttpStatus.OK);

	}

	@PutMapping("/icdcode")
	public ResponseEntity<Icd10Code> updateICDCodeById(@RequestBody Icd10Code icdCode) {

		Icd10Code updatedIcd = icd10CodeService.updateICDCodeById(icdCode);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Icd10Code>(updatedIcd, headers, HttpStatus.OK);
	}

}
