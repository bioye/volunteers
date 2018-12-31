package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group{

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
    private String name;
    @Id
    private int id;
}