package com.db.db.volunteers.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State{
    
    public int getCode() {
        return code;
    }

    public int getId() {
        return id;
    }
    @Id
    private int id;

    private int code;
}