package com.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "faculty",schema="test_schema")
@Entity
@Setter
@Getter
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "second_name")
	private String second_name; 
	
	@Column(name = "faculty_subject")
	private String faculty_subject;
	
}
