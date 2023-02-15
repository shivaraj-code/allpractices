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
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "country_table")
public class Country {

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private int country_id;

	@Column(name = "country_name")
	private String country_name;

	@OneToMany(targetEntity = State.class, cascade = CascadeType.ALL)
	private List<State> state;

	
}
