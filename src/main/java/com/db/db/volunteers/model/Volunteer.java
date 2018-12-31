package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Volunteer{

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

    private String name;
    private String phoneNo;
    private String position;
    private String code;
    @Id
    private int id;
}