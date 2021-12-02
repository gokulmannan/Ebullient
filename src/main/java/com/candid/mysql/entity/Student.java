package com.candid.mysql.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String username;
 	private String password;
	private int year;
	private int semster;
	private boolean fees;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Roles> role;
	
	
	
	

}
