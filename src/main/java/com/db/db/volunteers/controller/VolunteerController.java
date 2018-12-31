package com.db.db.volunteers.controller;

import com.db.db.volunteers.model.Form;
import com.db.db.volunteers.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"form"})
public class VolunteerController{

    @Autowired
    public VolunteerController(VolunteerService volunteerService, GroupService groupService,
                               LocalGovService localGovService, WardService wardService,
                               PollingUnitService pollingUnitService){
        this.volunteerService = volunteerService;
        this.groupService=groupService;
        this.localGovService=localGovService;
        this.wardService=wardService;
        this.pollingUnitService=pollingUnitService;
    }

	@GetMapping("/volunteers")
    public ModelAndView list(@PageableDefault(size=20, sort="name", 
                       direction=Sort.Direction.ASC) Pageable pageable, 
                       @ModelAttribute Form form, ModelAndView mv){
        //if(form.getVolunteersPage()==null){
            form.setGroupList(groupService.listAllGroups());
            form.setLocalGovs(localGovService.listAllLocalGovs());
            mv.setViewName("volunteers");
        //}
        form.setVolunteersPage(volunteerService.listAllVolunteers(pageable));
        return mv;
    }

    @PostMapping("/volunteers")
    public ModelAndView process(@ModelAttribute Form form, ModelAndView mv){
        form.setWards(wardService.findByLocalGov(form.getLocalGovId()));
        form.setPollingUnits(pollingUnitService.findByWard(form.getWardId()));
        mv.setViewName("volunteers");
        return mv;
    }

    
    @ModelAttribute
    public Form form() {
        return new Form();
    }

    private VolunteerService volunteerService;
    private GroupService groupService;
    private LocalGovService localGovService;
    private WardService wardService;
    private PollingUnitService pollingUnitService;
}