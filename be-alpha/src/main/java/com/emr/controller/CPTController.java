
package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.CPT;
import com.emr.service.CPTService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@RestController
public class CPTController {
	@Autowired
	private CPTService cptService;

	@RequestMapping("/hellocpt")
	public String echo() {
		return "welcome to cpt World...";
	}

	@PostMapping("/cpt/add")
	public ResponseEntity<String> addcpt(@RequestBody CPT cptRequest) {
		CPT cpt = cptService.addcpt(cptRequest);
		return ResponseEntity.status(201).body("CPT record added Successfully with Id " + cpt.getId());

	}
	
	@GetMapping("/cpt/list")
	public List<CPT> getCPTs() {
		return cptService.getCPTs();
	}

	@GetMapping("/list/{id}")
	public CPT getCPTById(@PathVariable int id) {
		return cptService.getCPTById(id);
	}

	@GetMapping("/shortname")
	public List<CPT> getCPTByShortName(@RequestParam String short_name) {
		return cptService.getCPTByShortName(short_name);
	}

	@GetMapping("/description")
	public List<CPT> getCPTByDescription(@RequestParam String description) {
		return cptService.getCPTByDescription(description);
	}

	@GetMapping("/createdby")
	public List<CPT> getCreatedByName(@RequestParam String created_by) {
		return cptService.getCreatedBy(created_by);
	}

	@GetMapping("/modifiedby")
	public List<CPT> getModifiedByName(@RequestParam String last_modified_by) {
		return cptService.getModifiedBy(last_modified_by);
	}

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@GetMapping("/createdbydate")
	public List<CPT> getcreatedByDate(@RequestParam String created_date) {

		return cptService.getcreatedByDate(created_date);
	}

	//@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Scheduled(fixedRate = 1000)
	@GetMapping("/lastmodifieddate")
	public List<CPT> getModifiedByDate(@RequestParam String last_modified_date) {
		return cptService.getModifiedByDate(last_modified_date);
	}

	/*
	 * @PutMapping("/cpt/update/{id}") public ResponseEntity<CPT>
	 * updateCpt(@RequestBody CPT cptcode) { CPT updateCPT =
	 * cptService.updateCPTById(cptcode); HttpHeaders headers = new HttpHeaders();
	 * return new ResponseEntity<CPT>(updateCPT, headers, HttpStatus.OK); }
	 */

	@PutMapping("/cpt/update")
	public ResponseEntity<String> updateCpt(@RequestBody CPT cptCode) {
		CPT cpt = cptService.updateCpt(cptCode);
		return ResponseEntity.status(201).body("CPT  Record Updated Successfully with Id " + cpt.getId());
	}

	@DeleteMapping("/cpt/delete/{id}")
	public ResponseEntity<String> deleteCptById(@PathVariable int id) {
		cptService.deleteCptById(id);
		return ResponseEntity.status(200).body("CPT Record Deleted Successfully");
	}

	@GetMapping("/pagination") public ResponseEntity<List<CPT>>
	  getCptByPagination(Pageable pageable) { 
	  Page<CPT> cptResponse = cptService.getAllCptByPagination(pageable);
	  HttpHeaders headers = new  HttpHeaders(); 
	  return new ResponseEntity<List<CPT>>(cptResponse.getContent(), headers, HttpStatus.OK);
	  }

	@GetMapping("/search")
	public List<CPT> getCPTByCode(@RequestParam(value = "searchstring", required = false) String code,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return cptService.getCPTByCode(code, pageable);
	}

	/*
	 * @GetMapping("/search") public List<CPT> getCPTByCode(@RequestParam(value =
	 * "searchstring", required = false) String code) { List<CPT> cptlist = null; if
	 * (code != null) { cptlist = cptService.getCPTByCode(code); } else { cptlist =
	 * cptService.getCPTs(); } return cptlist; }
	 */
	
	/*
	 * @GetMapping("cpt/pagination") public ResponseEntity<List<CPT>>
	 * getCPTPagination(Pageable pageable) {
	 * 
	 * pageable.getPageSize(); pageable.getNumber();
	 * 
	 * Page<CPT> cpt = cptService.getAllCPTPagination(pageable); HttpHeaders headers
	 * = new HttpHeaders(); return new ResponseEntity<List<CPT>>(cpt.getContent(),
	 * headers, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/cpt/search") public ResponseEntity<List<CPT>>
	 * getCptCodeByCodeOrShortOrDesc(@RequestParam String codeOrShortOrDesc,
	 * 
	 * @RequestParam Integer pageSize,@RequestParam Integer pageNumber) { Pageable
	 * pageable = (Pageable) PageRequest.of(pageNumber, pageSize); HttpHeaders
	 * headers = new HttpHeaders(); List<CPT> cptCodeResponse =
	 * cptService.getCptCodeByCodeOrShortOrDesc(codeOrShortOrDesc,pageable); return
	 * new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK);
	 */
	/*
	 * @GetMapping("/cpt/{pageNumber}/{pageSize}") public List<CPT>
	 * getCPT(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
	 * Page<CPT> data = cptService.getCPTPagination(pageNumber, pageSize, null);
	 * return data.getContent(); }
	 */
}

/*
 * @PostMapping("/cpt/add") public ResponseEntity<String> addcpt(@RequestBody
 * CPT cptrequest) { CPT cpt = cptService.addcpt(cptrequest); return
 * ResponseEntity.status(201).body("CPT Record added successfully with id" +
 * cpt.getId()); }
 */

/*
 * @PostMapping("/cpt/add") public ResponseEntity<String> addcpt(@RequestBody
 * CPT cptrequest) {
 * 
 * CPT cpt = cptService.addcpt(cptrequest); return
 * ResponseEntity.status(201).body("CPT Record added successfully with id" +
 * cpt.getId()); }
 */

// Get-Mapping Using Headers
/*
 * @GetMapping("/shortname") public ResponseEntity<List<CPT>>
 * getCPTByShortName(@RequestParam String short_name) {
 * 
 * List<CPT> cls = cptService.getCPTByShortName(short_name); HttpHeaders head =
 * new HttpHeaders(); return new ResponseEntity<>(cls, head, HttpStatus.OK); }
 */
