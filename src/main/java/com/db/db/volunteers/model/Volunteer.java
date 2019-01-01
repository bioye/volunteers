package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Volunteer{

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
    private String name;
    private String phoneNo;
    private String position;
    private String code;
    @Id
    private int id;
}