package com.db.db.volunteers.repository;

import com.db.db.volunteers.model.LocalGov;

import org.springframework.data.repository.CrudRepository;

public interface LocalGovRepository extends CrudRepository<LocalGov, Integer>{
	Iterable<LocalGov> findByStateId(int state);
	Iterable<LocalGov> findByStateCode(int code);
}