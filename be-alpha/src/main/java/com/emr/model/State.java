package com.emr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "state_table")
@Entity
public class State {

	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "state_id")
	private int state_id;

	@Column(name = "state_name")
	private String state_name;

	@Column(name = "state_capital")
	private String state_capital;

	@Column(name = "state_code")
	private String state_code;
	
	@ManyToOne
	@JoinColumn(name="country_id_fk")
	private Country country;

}
