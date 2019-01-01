package com.db.db.volunteers.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.db.db.volunteers.model.Ward;
import com.db.db.volunteers.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service("wardService")
public class WardService{

    public Iterable<Ward> findByLocalGov(int localGovId){
        return wardRepository.findByLocalGovId(localGovId);
    }

    public Optional<Ward> findWard(int id){
        return wardRepository.findById(id);
    }

    public Iterable<Ward> findByLocalGovCode(int code){
        return wardRepository.findByLocalGovCodeAndLocalGovStateCode(code, 27);
    }

    @Autowired
    public WardService(WardRepository wardRepository){
        this.wardRepository=wardRepository;
    }
    private WardRepository wardRepository;
}