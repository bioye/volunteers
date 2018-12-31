package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocalGov{
    
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
	private String name;
	private String code;
}