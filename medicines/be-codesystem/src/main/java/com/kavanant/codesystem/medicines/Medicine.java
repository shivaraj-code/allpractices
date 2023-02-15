package com.kavanant.codesystem.medicines;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicines_new")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Medicine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AIId")
    private int aiid;

    @Column(name = "Id")
    private int id;

    @Column(name = "NDC")
    private String ndc;

    @Column(name = "Name")
    private String name;

    @Column(name = "DEA")
    private int dea;

    @Column(name = "OBSDTEC")
    private String obsdtec;
    
    @Column(name = "Repack")
    private int repack;

    @Column(name = "IsCompounded")
    private String isCompounded;
    
    @Column(name = "data_source")
    private String data_source;

    @Column(name = "VersionState")
    private String versionState = "Validated";
    
    @Column(name = "Status")
    private String status = "Y";
    
    @Column(name = "isControlledSubstance")
    private Boolean isControlledSubstance;

    @Column(name = "CreatedBy")
    private Integer createdBy;
    
    @Column(name = "CreatedDate")
    private Date createdDate;
    
    @Column(name="LastModifiedBy")
    private Integer lastModifiedBy;
    
    @Column(name="lastModifiedDate")
    private Date lastModifiedDate;
    
    @Column(name = "RefId")
    private Integer refId;

    @Column(name = "OriginalRefId")
    private Integer originalRefId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OriginalCreatedDate")
    private Date originalCreatedDate;

}
