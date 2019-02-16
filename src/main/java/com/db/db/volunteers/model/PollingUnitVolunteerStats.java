package com.db.db.volunteers.model;

public class PollingUnitVolunteerStats{
    
    public long getVolunteers() {
        return volunteers;
    }
    
    /**
     * @return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the ward
     */
    public String getWard() {
        return ward;
    }

    /**
     * @param ward the ward to set
     */
    public void setWard(String ward) {
        this.ward = ward;
    }

    /**
     * @return the localGov
     */
    public String getLocalGov() {
        return localGov;
    }

    /**
     * @param localGov the localGov to set
     */
    public void setLocalGov(String localGov) {
        this.localGov = localGov;
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

    public PollingUnitVolunteerStats(String code, String name, int votes, 
            int points, long volunteers, String ward, String localGov) {
        this.setCode(code);
        this.setName(name);
        this.setVotes(votes);
        this.setPoints(points);
        this.setWard(ward);
        this.setLocalGov(localGov);
        this.setVolunteers(volunteers);
    }

    private String code;
    private String name;
    private int votes;
    private int points;
    private String ward;
    private String localGov;
    private long volunteers;
}