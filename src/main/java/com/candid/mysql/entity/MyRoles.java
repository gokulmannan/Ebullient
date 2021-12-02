package com.candid.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="myrole")
@Data
public class MyRoles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;

}
