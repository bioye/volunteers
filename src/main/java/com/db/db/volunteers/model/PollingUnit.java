package com.db.db.volunteers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PollingUnit{
    
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public int getId() {
		return id;
	}
	@Id
	private int id;
	
	@ManyToOne
	private Ward ward;
	private String name;
	@Column(name = "pu_id")
	private String code;
}