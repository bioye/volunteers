package com.db.db.volunteers.model;

public class PollingUnitVolunteerStats{
    
    public long getVolunteers() {
        return volunteers;
    }
    
    public void setVolunteers(long volunteers) {
        this.volunteers = volunteers;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public PollingUnitVolunteerStats(String code, String name, long volunteers){
        this.setCode(code);
        this.setName(name);
        this.setVolunteers(volunteers);
    }

    private String code;
    private String name;
    private long volunteers;
}