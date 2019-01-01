package com.db.db.volunteers.service;

import java.util.Optional;

import com.db.db.volunteers.model.LocalGov;
import com.db.db.volunteers.repository.LocalGovRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("localGovService")
public class LocalGovService {
    public Iterable<LocalGov> listAllLocalGovs(){
        return localGovRepository.findAll();
    }

    public Optional<LocalGov> findLocalGov(int id){
        return localGovRepository.findById(id);
    }

    public Iterable<LocalGov> findByState(int state){
        return localGovRepository.findByStateId(state);
    }

    public Iterable<LocalGov> findByStateCode(int code){
        return localGovRepository.findByStateCode(code);
    }

    @Autowired
    public LocalGovService(LocalGovRepository localGovRepository){
        this.localGovRepository=localGovRepository;
    }

    private LocalGovRepository localGovRepository;
}