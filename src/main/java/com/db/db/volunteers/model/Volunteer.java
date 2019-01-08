package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.JoinFormula;

@Entity
public class Volunteer{

    public PollingUnit getPollingUnit() {
        return pollingUnit;
    }
    /*
    public Ward getWard() {
        return ward;
    }*/

    public Group getGroup() {
        return group;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public String getPosition(){
        return position;
    }
    public String getCode(){
        return code;
    }
    @ManyToOne
    private Group group;
    @ManyToOne
    @JoinFormula(referencedColumnName="pu_loc_id",
                 value="CONCAT('OG',REPLACE(SUBSTRING(code,3),'-',''))")
    //convert from 27-01-02-003 to AB0102003
	//@JoinColumn(name = "full_code_hyphen")
    private PollingUnit pollingUnit;
    //@ManyToOne
    //private Ward ward;
    private String name;
    private String phoneNo;
    private String position;
    private String code;
    @Id
    private int id;
}