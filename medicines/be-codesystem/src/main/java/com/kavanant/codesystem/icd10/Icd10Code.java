package com.kavanant.codesystem.icd10;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "icd10_codes")
public class Icd10Code {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public int id;

	@Column(name = "ICDOrder")
	public String icdOrder;

	@Column(name = "ICDCode")
	public String icdCode;

	@Column(name = "ICDId")
	public Integer icdId;

	@Column(name = "Type")
	public Character type;

	@Column(name = "ShortDesc")
	public String shortDesc;

	@Column(name = "MedDesc")
	public String medDesc;

	@Column(name = "LongDesc")
	public String longDesc;

	@Column(name = "RefId", nullable = true)
	public Integer refId;

	@Column(name = "Retired", nullable = true)
	public String retired;

	@Column(name = "VersionState", nullable = true)
	public String versionState;

	@Column(name = "OriginalRefId", nullable = true)
	public Integer originalRefId;

	@Column(name = "CreatedBy", nullable = true)
	public Integer createdBy;

	@Column(name = "CreatedDate", nullable = false)
	public Date createdDate;

	@Column(name = "ModifiedBy", nullable = true)
	public Integer modifiedBy;

	@Column(name = "ModifiedDate", nullable = false)
	public Date modifiedDate;

	@Column(name = "RetiredOn", nullable = true)
	public Date retiredOn;

	@Column(name = "RetiredReason", nullable = true)
	public String retiredReason;
}
