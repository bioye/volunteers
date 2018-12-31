package com.db.db.volunteers.service;

import com.db.db.volunteers.model.PollingUnit;
import com.db.db.volunteers.repository.PollingUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pollingUnitService")
public class PollingUnitService{

    public Iterable<PollingUnit> findByWard(int pollingUnitId){
        return pollingUnitRepository.findByWardId(pollingUnitId);
    }

    @Autowired
    public PollingUnitService(PollingUnitRepository pollingUnitRepository){
        this.pollingUnitRepository=pollingUnitRepository;
    }
    private PollingUnitRepository pollingUnitRepository;
}