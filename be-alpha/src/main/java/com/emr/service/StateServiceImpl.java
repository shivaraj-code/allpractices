package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.State;
import com.emr.repository.StateRepository;
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;
	
	@Override
	public State createState(State staterequest) {
		// TODO Auto-generated method stub
		return stateRepository.save(staterequest);
	}

	@Override
	public List<State> getState() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

}
