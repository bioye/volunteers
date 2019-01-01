package com.db.db.volunteers.controller;

import com.db.db.volunteers.model.Form;
import com.db.db.volunteers.model.QVolunteer;
import com.db.db.volunteers.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.querydsl.core.BooleanBuilder;

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
        form.setGroupList(groupService.listAllGroups());
        form.setLocalGovs(localGovService.findByStateCode(27));
        mv.setViewName("volunteers");
        form.setVolunteersPage(volunteerService.listAllVolunteers(pageable));
        return mv;
    }

    @PostMapping("/volunteers")
    public ModelAndView process(@ModelAttribute Form form, ModelAndView mv){
        form.setWards(wardService.findByLocalGov(form.getLocalGovId()));
        form.setPollingUnits(pollingUnitService.findByWard(form.getWardId()));
        StringBuilder subCode = new StringBuilder("27-");
        int groupId=form.getGroupId();
        BooleanBuilder filterBuilder = new BooleanBuilder();
        if(groupId!=0) filterBuilder.and(QVolunteer.volunteer.group.id.eq(groupId));
        if(form.getLocalGovId()!=0){
            subCode.append(String.format("%02d",localGovService.findLocalGov(
                                                                form.getLocalGovId()).get().getCode()));
            if(form.getWardId()!=0){
                subCode.append("-");
                subCode.append(String.format("%02d",wardService.findWard(
                                                                form.getWardId()).get().getCode()));
                if(form.getPollingUnitId()!=0){
                    subCode.append("-");
                    subCode.append(String.format("%03d",pollingUnitService.findPollingUnit(
                                                                        form.getPollingUnitId()).get().getCode()));
                }
            }
            filterBuilder.and(QVolunteer.volunteer.code.startsWith(subCode.toString()));
        }
        PageRequest page = PageRequest.of(form.getVolunteersPage().getNumber(), 
                                               form.getVolunteersPage().getSize(),
                                               new Sort(Sort.Direction.ASC,"name"));
        form.setVolunteersPage(volunteerService.listAllVolunteers(filterBuilder, page));
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