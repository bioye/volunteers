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
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }

    private String type;
    private String name;
    @Id
    private int id;
}