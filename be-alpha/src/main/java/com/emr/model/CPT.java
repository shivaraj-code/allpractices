package com.emr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Entity
@Data
@Table(name = "cpt")
public class CPT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "description")
	private String description;

	@Column(name = "ishcpcs")
	private Boolean ishcpcs;

	//@Column(name = "status")
	//private Character status = 'Y';

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	//@Temporal(TemporalType.TIMESTAMP)
	//@JsonFormat(pattern ="yyyy-MM-dd", shape=Shape.STRING)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;

	@Column(name = "created_by")
	private String createdBy;

	//@Temporal(TemporalType.TIMESTAMP)
	//@JsonFormat(pattern ="yyyy-MM-dd", shape=Shape.STRING)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "retired")
	private Character retired ='N';

	@Column(name = "RefId")
	private Integer refId;

	@Column(name="OriginalRefId")
	private int originalRefId ;
	
	@Column(name="VersionState")
	private String versionState ="Valid";
	
	@Column(name="RetiredDate")
	private Date retireddate;
	
	@Column(name="RetiredReason")
	private String retiredReason;
		
	@ManyToOne
	@JoinColumn(name="c_id_fk", referencedColumnName = "c_id")
	private CptCategory cptcategory;
}
