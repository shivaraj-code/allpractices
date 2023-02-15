package com.kavanant.codesystem.cpt;


//import java.sql.Timestamp;
import java.util.Date; 
//import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


import lombok.Data;

@Entity
@Data
@Table(name="cpt_short")
public class CptCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	public int id;
	@Column(name="Code")
	public String code; 
    @Column(name="ShortName")
	public String shortName;  
	@Column(name="Description")
	public String description;
	@Column(name="IsHCPCS")
	public Integer isHcpcs; 
	@Column(name="RefId", nullable=true)
	public Integer refId;
	@Column(name="Retired", nullable=true)
	public String retired;
	@Column(name="VersionState",nullable=true)
	public String versionState;
	@Column(name="OriginalRefId", nullable=true)
	public Integer originalRefId;
	//@Column(name="Status", nullable=true)
	//public Character status;
	@Column(name="CreatedBy", nullable=true)
	public Integer createdBy; 
	//@CreationTimestamp
	//@Temporal(TemporalType.DATE)
	@Column(name="CreatedDate", nullable=false)
	public Date createdDate;
	@Column(name="ModifiedBy", nullable=true)
	public Integer modifiedBy;
	//@CreationTimestamp
    @Column(name = "ModifiedDate",nullable=false)
    public Date modifiedDate; 
	@Column(name="RetiredOn", nullable=true)
	public Date retiredOn;
	@Column(name="RetiredReason", nullable=true)
	public String retiredReason;
}
