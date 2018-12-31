package com.db.db.volunteers.model;

import org.springframework.data.domain.Page;

public class Form {

    public int getLocalGovId() {
        return localGovId;
    }
    
    public int getPollingUnitId() {
        return pollingUnitId;
    }
    public void setPollingUnitId(int pollingUnitId) {
        this.pollingUnitId = pollingUnitId;
    }

    public Iterable<PollingUnit> getPollingUnits() {
        return pollingUnits;
    }
    public void setPollingUnits(Iterable<PollingUnit> pollingUnits) {
        this.pollingUnits = pollingUnits;
    }

    public Iterable<Ward> getWards() {
        return wards;
    }
    public void setWards(Iterable<Ward> wards) {
        this.wards = wards;
    }

    public void setLocalGovId(int localGovId) {
        this.localGovId = localGovId;
    }

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getWardId() {
        return wardId;
    }
    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public Iterable<Group> getGroupList() {
        return groupList;
    }
    public void setGroupList(Iterable<Group> groupList) {
        this.groupList = groupList;
    }

    public Iterable<LocalGov> getLocalGovs() {
        return localGovs;
    }
    public void setLocalGovs(Iterable<LocalGov> localGovs) {
        this.localGovs = localGovs;
    }

    public Page<Volunteer> getVolunteersPage() {
        return volunteersPage;
    }
    public void setVolunteersPage(Page<Volunteer> volunteersPage) {
        this.volunteersPage = volunteersPage;
    }
    private int localGovId;
    private int groupId;
    private int wardId;
    private int pollingUnitId;
    private Iterable<Group> groupList;
    private Iterable<LocalGov> localGovs;
    private Iterable<Ward> wards;
    private Iterable<PollingUnit> pollingUnits;
    private Page<Volunteer> volunteersPage;
}