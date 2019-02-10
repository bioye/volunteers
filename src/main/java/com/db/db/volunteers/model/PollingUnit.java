package com.db.db.volunteers.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PollingUnit implements Serializable{

	private static final long serialVersionUID = 1759791770074149187L;

	public String getFullCode() {
		return fullCode;
	}

	public String getName() {
		return name.trim();
	}
	public int getCode() {
		return code;
	}
	public int getId() {
		return id;
	}

	@Id
	private int id;
	@Column(name="pu_loc_id")
	private String fullCode;
	@ManyToOne
	private Ward ward;
	//@Column(name="description")
	private String name;
	@Column(name = "pu_id")
	private int code;
}