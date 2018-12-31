package com.db.db.volunteers.repository;

import com.db.db.volunteers.model.Volunteer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("volunteerRepository")
public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Integer>{
    Volunteer findByPhoneNo(String phoneNo);
}