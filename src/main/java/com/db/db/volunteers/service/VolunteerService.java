package com.db.db.volunteers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.db.db.volunteers.repository.VolunteerRepository;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

import com.db.db.volunteers.model.PollingUnit;
import com.db.db.volunteers.model.PollingUnitVolunteerStats;
import com.db.db.volunteers.model.Volunteer;

@Service("volunteerService")
public class VolunteerService{

    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    public List<PollingUnit> listPollingUnitWithNoVolunteer(){
        return volunteerRepository.findPollingUnitsWithNoVolunteers();
    }

    public List<PollingUnitVolunteerStats> listPollingUnitVolunteerStats(){
        return volunteerRepository.findPollingUnitsByVolunteerCount();
    }
    /*
    public Page<PollingUnitVolunteerStats> listPollingUnitVolunteerStats(BooleanBuilder builder, Pageable page){
        return volunteerRepository.findPollingUnitsByVolunteerCount(builder, page);
    }

    public Page<PollingUnitVolunteerStats> listPollingUnitVolunteerStats(Pageable page){
        return volunteerRepository.findPollingUnitsByVolunteerCount(page);
    }*/

    public Page<Volunteer> listAllVolunteers(Pageable page){
        return volunteerRepository.findAll(page);
    }

    public Page<Volunteer> listAllVolunteers(BooleanBuilder builder, Pageable page){
        return volunteerRepository.findAll(builder, page);
    }
    private VolunteerRepository volunteerRepository;
}