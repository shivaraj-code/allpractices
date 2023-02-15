package com.emr.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="cpt_categories")
@Entity
public class CptCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_Id")
	private int c_id;
	
	@Column(name="CPT Major Category")
	private String cptMajorCategory;
	
	@Column(name="CPT Minor Category")
	private String cptMinorCategory;
	
	@Column(name="Start Code")
	private String startCode;
	
	@Column(name="End Code")
	private String endCode;

	@OneToMany(targetEntity = CPT.class, cascade=CascadeType.ALL)
	private List<CPT> cpt;

}
