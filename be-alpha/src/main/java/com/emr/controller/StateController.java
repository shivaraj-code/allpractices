package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.State;
import com.emr.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@RequestMapping("/hellostate")
	public String raju() {
		return "Welcome to My World.. State...";
	}
	@PostMapping("/state/add")
	public ResponseEntity<String> createState(@RequestBody State staterequest){
		
		State st=stateService.createState(staterequest);
		return ResponseEntity.status(201).body("State Records Created Successfully with State Id"+st.getState_id());
	}
	
	@GetMapping("/state/list")
	public List<State> getState(){
		return stateService.getState();
	}

}
