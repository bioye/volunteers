package com.db.db.volunteers.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PollingUnit implements Serializable{

	private static final long serialVersionUID = 1759791770074149187L;

	public Ward getWard() {
		return ward;
	}
	
	public String getFullCode() {
		return fullCode;
	}

	/**
	 * @return the votes
	 */
	public int getVotes() {
		return voters;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
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
	@Column(name = "pu_loc_id")
	private String fullCode;
	@ManyToOne
	private Ward ward;
	// @Column(name="description")
	private String name;
	@Column(name = "pu_id")
	private int code;
	private int voters;
	private int points;
}