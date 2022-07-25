package com.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "doctor", schema = "test_schema")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fname;
	private String lname;
	private String departname;

}
