package com.db.db.volunteers.controller;

import com.db.db.volunteers.model.Form;
import com.db.db.volunteers.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VolunteerController{

    @Autowired
    public VolunteerController(VolunteerService volunteerService, GroupService groupService,
                               LocalGovService localGovService, WardService wardService){
        this.volunteerService = volunteerService;
        this.groupService=groupService;
        this.localGovService=localGovService;
        this.wardService=wardService;
    }

	@GetMapping("/volunteers")
    public ModelAndView list(@PageableDefault(size=20, sort="name", 
                       direction=Sort.Direction.ASC) Pageable pageable, ModelAndView mv){
        mv.addObject("groupList", groupService.listAllGroups());
        mv.addObject("localGovs", localGovService.listAllLocalGovs());
        mv.addObject("volunteersPage", volunteerService.listAllVolunteers(pageable));
        mv.addObject("form", new Form());
        mv.setViewName("volunteers");
        return mv;
    }

    @PostMapping("/volunteers")
    public ModelAndView process(@ModelAttribute Form form, ModelAndView mv){
        mv.addObject("wards", wardService.findByLocalGovs(form.getLocalGovId()));
        mv.setViewName("volunteers");
        return mv;
    }

    private VolunteerService volunteerService;
    private GroupService groupService;
    private LocalGovService localGovService;
    private WardService wardService;
}