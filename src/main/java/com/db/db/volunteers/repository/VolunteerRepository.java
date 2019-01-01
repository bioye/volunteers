package com.db.db.volunteers.repository;

import com.db.db.volunteers.model.Volunteer;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("volunteerRepository")
public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Integer>, 
                                             QuerydslPredicateExecutor<Volunteer>{
    Volunteer findByPhoneNo(String phoneNo);
}