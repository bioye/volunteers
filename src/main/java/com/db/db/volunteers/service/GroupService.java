package com.db.db.volunteers.service;

import com.db.db.volunteers.model.Group;
import com.db.db.volunteers.repository.GroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupService{

    public Iterable<Group> listAllGroups(){
        return groupRepository.findAllByOrderByNameAsc();
    }

    @Autowired
    public GroupService(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }
    private GroupRepository groupRepository;
}