package com.kavanant.codesystem.cpt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class CptCategory {
    	
    	    @Id
    		public int id;
    		public String code; 
    	    public String shortName;  
    		public String description;
    		public Integer isHcpcs; 
    		public Integer refId;
    		public String retired;
    		public String versionState;
    		public Integer originalRefId;
    		public Integer createdBy; 
    		public Date  createdDate;
    		public Integer modifiedBy;
    		public Date modifiedDate; 
    		public Date retiredOn;
    		public String retiredReason; 
    		public String cptMajorCategory;
    		public String cptMinorCategory;
		
	}
		
