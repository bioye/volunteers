package com.db.db.volunteers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.db.volunteers.model.LocalGov;
import com.db.db.volunteers.model.Ward;

@Repository("wardRepository")
public interface WardRepository extends CrudRepository<Ward, Integer>{
    Iterable<Ward> findByLocalGov(LocalGov localGov);
    Iterable<Ward> findByLocalGovId(int localGovId);
    Iterable<Ward> findByLocalGovCode(int code);
    Iterable<Ward> findByLocalGovCodeAndLocalGovStateCode(int code0, int code1);
}