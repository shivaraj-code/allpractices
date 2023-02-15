package com.emr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CptCategory_1 {

	@Id
	private String code;
	private String shortName;
	private String description;
	private String majorCategory;
	private String minorCategory;
	 
}
