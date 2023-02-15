package com.kavanant.codesystem.cpt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CptCodeController {

	@Autowired
	CptCodeService cptCodeService;

	/*
	 * @GetMapping(path = "/cptcode/list") public ResponseEntity<List<CptCode>>
	 * getCptCodes() {
	 * 
	 * List<CptCode> cptCodes = cptCodeService.getAllCptCodes(); HttpHeaders headers
	 * = new HttpHeaders(); return new ResponseEntity<List<CptCode>>(cptCodes,
	 * headers, HttpStatus.OK); }
	 */

	@GetMapping("/cptcode/pagination")
	public ResponseEntity<List<CptCode>> getCptCodesByPagination(@RequestParam Integer pageSize,
			@RequestParam Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<CptCode> cptCodes = cptCodeService.getAllCptCodesByPagination(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<CptCode>>(cptCodes.getContent(), headers, HttpStatus.OK);
	}

	@PostMapping("/cptcode")
	public ResponseEntity<CptCode> addCptCode(@RequestBody CptCode cptCode) {

		CptCode cptCodeResponse = cptCodeService.addCptCode(cptCode);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<CptCode>(cptCodeResponse, headers, HttpStatus.OK);

	}

	@PutMapping("/cptcode")
	public ResponseEntity<CptCode> updateCptCodeById(@RequestBody CptCode cptCode) {

		CptCode updatedCptCode = cptCodeService.updateCptCodeById(cptCode);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<CptCode>(updatedCptCode, headers, HttpStatus.OK);
	}

	@GetMapping("/cptcode/searchwithctg")
	public ResponseEntity<List<CptCategory>> getCptCodeByCodeOrShortOrDescWithCtg(@RequestParam String codeordesc,
			@RequestParam int pageNumber, @RequestParam int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		List<CptCategory> cptCodeResponse = cptCodeService.getCptCodeByCodeOrShortOrDescWithCtg(codeordesc, pageable);
		return new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK);
	}

	/*
	 * @GetMapping(path = "/cptcode/searchwithctg") public
	 * ResponseEntity<List<CptCategory>>
	 * getCptCodeByCodeOrShortOrDescWithCtg(@RequestParam String codeordesc,
	 * 
	 * @RequestParam Integer pageSize, @RequestParam Integer pageNumber) { Pageable
	 * pageable = PageRequest.of(pageNumber, pageSize); HttpHeaders headers = new
	 * HttpHeaders(); List<CptCategory> cptCodeResponse =
	 * cptCodeService.getCptCodeByCodeOrShortOrDescWithCtg(codeordesc,pageable);
	 * return new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK); m }
	 */

	@GetMapping("/cptcode/search")
	public ResponseEntity<List<CptCode>> getCptCodeByCodeOrShortOrDesc(
			@RequestParam(value = "searchstring", required = false) String codeOrShortOrDesc,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		List<CptCode> cptCodeResponse = cptCodeService.getCptCodeByCodeOrShortOrDesc(codeOrShortOrDesc, pageable);
		return new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK);

	}

	@GetMapping(path = "/cptcode/{id}")
	public ResponseEntity<Optional<CptCode>> getCptCodes(@PathVariable int id) {
		Optional<CptCode> cptCode = cptCodeService.getCptCodeById(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Optional<CptCode>>(cptCode, headers, HttpStatus.OK);
	}

	/*
	 * @GetMapping(path="/cptcode/code") public ResponseEntity<Optional<CptCode>>
	 * getCptCodeByCode(@RequestParam String code){
	 * 
	 * Optional<CptCode> cptCodes = cptCodeService.getCptCodeByCode(code);
	 * HttpHeaders headers = new HttpHeaders(); return new
	 * ResponseEntity<Optional<CptCode>>(cptCodes, headers, HttpStatus.OK); }
	 * 
	 * @GetMapping(path="/cptcode/date") public ResponseEntity<List<CptCode>>
	 * getCptCodeByDate(@RequestParam Date date,Pageable pageable){
	 * 
	 * List<CptCode> cptCodes = cptCodeService.getCptCodeByDate(date,pageable);
	 * HttpHeaders headers = new HttpHeaders(); return new
	 * ResponseEntity<>(cptCodes, headers, HttpStatus.OK); }
	 */
	/*
	 * @DeleteMapping(path="/cptcode") public ResponseEntity<String>
	 * deleteCptCodeByCode(@RequestParam String code){
	 * 
	 * String deleteStatus = cptCodeService.deleteCptCodeByCode(code); HttpHeaders
	 * headers = new HttpHeaders(); return new ResponseEntity<String>(deleteStatus,
	 * headers, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping(path="/cptcode/{id}") public ResponseEntity<Optional<CptCode>>
	 * getCptCodes(@PathVariable int id){
	 * 
	 * Optional<CptCode> cptCode = cptCodeService.getCptCodeById(id); HttpHeaders
	 * headers = new HttpHeaders(); return new
	 * ResponseEntity<Optional<CptCode>>(cptCode, headers, HttpStatus.OK); }
	 */
}
