package com.emr.service;

import java.util.List;

import com.emr.model.State;

public interface StateService {

	State createState(State staterequest);

	List<State> getState();

}
