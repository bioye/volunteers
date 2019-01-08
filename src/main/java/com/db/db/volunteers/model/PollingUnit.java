package com.db.db.volunteers.model;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

@Entity
public class PollingUnit implements Serializable{

    public String getFullCode(){
		return fullCode;
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
	/*@PostLoad
	private void onLoad(){	
		StringBuilder statePart=new StringBuilder("27");
		String localGovPart=fullCode.substring(2,5);
		String wardPart=fullCode.substring(5,8);
		String pollingUnitPart=fullCode.substring(8,12);
		fullCodeHyphen = statePart.append("-").append(localGovPart).append("-")
							.append(wardPart).append("-").append(pollingUnitPart).toString();
		fullCodeSlash=fullCodeHyphen.replace("/","-");
	}*/

	@Id
	private int id;
	
	//@Transient
	//private String fullCodeHyphen;	
	//@Transient
	//private String fullCodeSlash;
	@Column(name="pu_loc_id")
	private String fullCode;
	@ManyToOne
	private Ward ward;
	@Column(name="description")
	private String name;
	@Column(name = "pu_id")
	private int code;
}