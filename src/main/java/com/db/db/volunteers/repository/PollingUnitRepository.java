package com.db.db.volunteers.repository;

import com.db.db.volunteers.model.PollingUnit;
import com.db.db.volunteers.model.Ward;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("pollingUnitRepository")
public interface PollingUnitRepository extends CrudRepository<PollingUnit, Integer>{
    Iterable<PollingUnit> findByWard(Ward ward);
    Iterable<PollingUnit> findByWardId(int wardId);
    Iterable<PollingUnit> findByWardCode(int code);
}