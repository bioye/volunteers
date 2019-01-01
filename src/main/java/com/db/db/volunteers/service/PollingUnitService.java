package com.db.db.volunteers.service;

import java.util.Optional;

import com.db.db.volunteers.model.PollingUnit;
import com.db.db.volunteers.repository.PollingUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pollingUnitService")
public class PollingUnitService{

    public Iterable<PollingUnit> findByWard(int pollingUnitId){
        return pollingUnitRepository.findByWardId(pollingUnitId);
    }

    public Optional<PollingUnit> findPollingUnit(int id){
        return pollingUnitRepository.findById(id);
    }

    public Iterable<PollingUnit> findByWardCode(int code){
        return pollingUnitRepository.findByWardCode(code);
    }

    @Autowired
    public PollingUnitService(PollingUnitRepository pollingUnitRepository){
        this.pollingUnitRepository=pollingUnitRepository;
    }
    private PollingUnitRepository pollingUnitRepository;
}