package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ward{	

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public LocalGov getLocalGov() {
		return localGov;
	}	

	@Id
	private int id;

	@ManyToOne
	private LocalGov localGov;
	private String name;
	private String code;
}