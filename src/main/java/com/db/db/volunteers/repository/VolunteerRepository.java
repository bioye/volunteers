package com.db.db.volunteers.repository;

import com.db.db.volunteers.model.Volunteer;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

import com.db.db.volunteers.model.PollingUnit;
import com.db.db.volunteers.model.PollingUnitVolunteerStats;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("volunteerRepository")
public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Integer>, 
                                             QuerydslPredicateExecutor<Volunteer>{
    Volunteer findByPhoneNo(String phoneNo);

    @Query("select new com.db.db.volunteers.model.PollingUnitVolunteerStats("
            +"v.code, v.pollingUnit.name, v.pollingUnit.voters as votes, v.pollingUnit.points, count(v) as volunteers,"
             +"v.pollingUnit.ward.name as ward, v.pollingUnit.ward.localGov.name as localGov) from Volunteer v "
            +"group by v.code, v.pollingUnit.name, v.pollingUnit.voters, v.pollingUnit.points, v.pollingUnit.ward.name,"
            +" v.pollingUnit.ward.localGov.name")
    List<PollingUnitVolunteerStats> findPollingUnitsByVolunteerCount();

    @Query("select new com.db.db.volunteers.model.PollingUnitVolunteerStats("
            +"v.code, v.pollingUnit.name as name, v.pollingUnit.voters as votes, v.pollingUnit.points, count(v) as volunteers,"
             +"v.pollingUnit.ward.name as ward, v.pollingUnit.ward.localGov.name as localGov) from Volunteer v "
            +"group by v.code, v.pollingUnit.name, v.pollingUnit.voters, v.pollingUnit.points, v.pollingUnit.ward.name,"
            +" v.pollingUnit.ward.localGov.name")
    Page<PollingUnitVolunteerStats> findPollingUnitsByVolunteerCount(BooleanBuilder builder, Pageable page);

    @Query("select new com.db.db.volunteers.model.PollingUnitVolunteerStats("
            +"v.code, v.pollingUnit.name, v.pollingUnit.voters as votes, v.pollingUnit.points, count(v) as volunteers,"
             +"v.pollingUnit.ward.name as ward, v.pollingUnit.ward.localGov.name as localGov) from Volunteer v "
            +"group by v.code, v.pollingUnit.name, v.pollingUnit.voters, v.pollingUnit.points, v.pollingUnit.ward.name,"
            +" v.pollingUnit.ward.localGov.name")
    Page<PollingUnitVolunteerStats> findPollingUnitsByVolunteerCount(Pageable page);

    @Query("select p from PollingUnit p where p.fullCode not in (select distinct v.pollingUnit.fullCode from Volunteer v)")
    List<PollingUnit> findPollingUnitsWithNoVolunteers();

    @Query("select p from PollingUnit p where p.fullCode not in (select distinct v.pollingUnit.fullCode from Volunteer v)")
    Page<PollingUnit> findPollingUnitsWithNoVolunteers(BooleanBuilder builder, Pageable page);

    @Query("select p from PollingUnit p where p.fullCode not in (select distinct v.pollingUnit.fullCode from Volunteer v)")
    Page<PollingUnit> findPollingUnitsWithNoVolunteers(Pageable page);
    
    public Page<Volunteer> findAllByOrderByNameAsc(Pageable page);//
    public Page<Volunteer> findAllByOrderByNameAsc(BooleanBuilder builder, Pageable page);//
    public List<Volunteer> findAllByOrderByNameAsc();


    

    //@Query("select count(v.group.name) from volunteer v group by v.group where substring(v.code, 3)==lg.code")
    //Iterable<Group> findGroups();
}
