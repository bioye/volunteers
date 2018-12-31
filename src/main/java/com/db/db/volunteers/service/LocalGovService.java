package com.db.db.volunteers.service;

import com.db.db.volunteers.model.LocalGov;
import com.db.db.volunteers.repository.LocalGovRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("localGovService")
public class LocalGovService {
    public Iterable<LocalGov> listAllLocalGovs(){
        return localGovRepository.findAll();
    }

    @Autowired
    public LocalGovService(LocalGovRepository localGovRepository){
        this.localGovRepository=localGovRepository;
    }

    private LocalGovRepository localGovRepository;
}