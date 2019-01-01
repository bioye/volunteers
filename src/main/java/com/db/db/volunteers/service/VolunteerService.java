package com.db.db.volunteers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.db.db.volunteers.repository.VolunteerRepository;
import com.querydsl.core.BooleanBuilder;
import com.db.db.volunteers.model.Volunteer;

@Service("volunteerService")
public class VolunteerService{

    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    public Page<Volunteer> listAllVolunteers(Pageable page){
        return volunteerRepository.findAll(page);
    }

    public Page<Volunteer> listAllVolunteers(BooleanBuilder builder, Pageable page){
        return volunteerRepository.findAll(builder, page);
    }
    private VolunteerRepository volunteerRepository;
}