package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LocalGov{
	
	public State getState() {
		return state;
	}
    
	public String getName() {
		return name;
	}
	public int getCode() {
		return code;
	}
	public int getId() {
		return id;
	}
	@ManyToOne
	private State state;
	@Id
	private int id;
	private String name;
	private int code;
}