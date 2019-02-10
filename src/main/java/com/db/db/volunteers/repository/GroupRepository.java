package com.db.db.volunteers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.db.db.volunteers.model.*;

@Repository("groupRepository")
public interface GroupRepository extends CrudRepository<Group, Integer>{
    public List<Group> findAllByOrderByNameAsc();
}