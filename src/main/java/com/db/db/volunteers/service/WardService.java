package com.db.db.volunteers.service;

import org.springframework.stereotype.Service;
import com.db.db.volunteers.model.Ward;
import com.db.db.volunteers.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service("wardService")
public class WardService{

    public Iterable<Ward> findByLocalGovs(int localGovId){
        return wardRepository.findByLocalGovId(localGovId);
    }

    public Iterable<Ward> listAllWards(){
        return wardRepository.findAll();
    }

    @Autowired
    public WardService(WardRepository wardRepository){
        this.wardRepository=wardRepository;
    }
    private WardRepository wardRepository;
}